package com.qoobico.remindme;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.qoobico.remindme.model.Sights;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ListSightsActivity extends AppCompatActivity {
    private String  chosenCountry;
    private ArrayList<Sights> sightsArrayListMain;
    Networking nw;

    static String port = "6666";
    static String address = "192.168.0.33";
    String fromUser;
    String fromServer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sights);
        Intent intent = getIntent();
        chosenCountry = intent.getStringExtra("country");
        //Toast.makeText(getBaseContext(), "Chosen country is " + chosenCountry, Toast.LENGTH_LONG).show();
        sightsArrayListMain = new ArrayList<Sights>();
        
        fillArrayList();
        fillListView();
        registerCallBack();
    }



    private void fillListView() {
        Log.d("MyLogs","Entered in class ListSightsActivity method fillListView");
        ArrayAdapter<Sights> adapter = new MyListAdapter();
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        Log.d("MyLogs", "Entered in class ListSightsActivity method fillListView FINISH");
    }

    private void fillArrayList() {
        Log.d("MyLogs","Entered in class ListSightsActivity method fillArrayList");
        nw = new Networking();
        nw.execute(chosenCountry,port,address);
        try {
            sightsArrayListMain = nw.get();
            Log.d("MyLogs","-----------------Size of sightsArrayListMain  = " + sightsArrayListMain.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("MyLogs","Entered in class ListSightsActivity method fillArrayList FINISH");

    }

    private void registerCallBack() {
        Log.d("MyLogs","Entered in class ListSightsActivity method registerCallBack");
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {

                Sights clickedSIght = sightsArrayListMain.get(position);
                String message = "You clicked position " + position
                        + " Which is sight " + clickedSIght.getName();
                //Toast.makeText(ListSightsActivity.this, message, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ListSightsActivity.this, ConcreteSightActivity.class);
                intent.putExtra("id", clickedSIght.getId().toString());
                intent.putExtra("name", clickedSIght.getName().toString());
                intent.putExtra("country", clickedSIght.getCountry().toString());
                intent.putExtra("coordination", clickedSIght.getCoordination().toString());
                intent.putExtra("description", clickedSIght.getDescription().toString());
                startActivity(intent);
            }
        });
    }

    private class MyListAdapter extends ArrayAdapter<Sights>{

        public MyListAdapter(){
            super(ListSightsActivity.this,R.layout.item_view,sightsArrayListMain);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if(itemView == null){
                itemView = getLayoutInflater().inflate(R.layout.item_view,parent,false);
            }
            //Find the Sight
            Sights currentSight = sightsArrayListMain.get(position);

            //Fill the view

            TextView item_txtMake = (TextView)itemView.findViewById(R.id.item_txtName);
            item_txtMake.setText(currentSight.getName());

            TextView item_txtId = (TextView)itemView.findViewById(R.id.item_txtId);
            item_txtId.setText(currentSight.getId().toString());


            TextView item_txtCountry = (TextView)itemView.findViewById(R.id.item_txtCountry);
            item_txtCountry.setText(currentSight.getCountry());

            return  itemView;
        }
    }

    class Networking extends AsyncTask<String,JSONArray,ArrayList<Sights>>{

        private JSONArray jArray;
        private String chosenCountry;
        private Integer  port;
        private String address;
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        InetAddress host = null;
        BufferedReader stdIn = null;
        String fromServer;
        Sights sights = null;

        @Override
        protected ArrayList<Sights> doInBackground(String... params) {
            Log.d("MyLogs","Entered in class Networking doInBackGround");
            //Получение параметров для работы в сети
            chosenCountry = params[0];
            port = new Integer(params[1]);
            address = params[2];
            ArrayList<Sights> arls = new ArrayList<Sights>();
            Log.d("MyLogs","Chosen country is "+ chosenCountry+" ,port is " + port + " ,address is " + address);
            //Инициализация сокетов и потоков.
            try {
                Log.d("MyLogs", "Before initializing host and socket ");
                host = InetAddress.getByName(address);
                Log.d("MyLogs", "HOST =  "+ host + "  Host.getHostName = " + host.getHostName());

                socket = new Socket("192.168.0.33", port);
                Log.d("MyLogs", "After initializing host and socket  " );
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                stdIn = new BufferedReader(new InputStreamReader(System.in));
                //Отправка 1-ого сообщения на сервер
                out.println(chosenCountry);
                Log.d("MyLogs", "The first message whish is sent to the server is  " + chosenCountry);
                while ((fromServer = in.readLine()) != null) {
                    fromServer =  fromServer.substring(1,fromServer.length()-1);
                    String output = fromServer.replace("[", "").replace("]", "");
                    Log.d("MyLogs","String which we got from server is  " + fromServer);

                    jArray = new JSONArray(fromServer);

                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject jObj = jArray.getJSONObject(i);
                        sights = new Sights(jObj.getInt("id"),jObj.getString("name"),jObj.getString("country"),jObj.getString("coordination"),jObj.getString("description"));
                        Log.d("MyLogs", "Info about sights name " + sights.getId() + sights.getName()+sights.getCountry()+sights.getCoordination()+sights.getDescription());
                        arls.add(sights);
                    }
                    in.close();
                    out.close();
                    stdIn.close();
                    socket.close();
                }
                Log.d("MyLogs","Entered in class Networking method doInBackGround FINISH");
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return arls;
        }

        @Override
        protected void onPostExecute(ArrayList<Sights> sightses) {
            Log.d("MyLogs", "Entered in class Networking onPostExecute");
            super.onPostExecute(sightses);

            Log.d("MyLogs","Entered in class Networking onPostExecute FINISH");

        }
    }
}
