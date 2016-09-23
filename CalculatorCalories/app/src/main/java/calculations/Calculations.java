package calculations;

/**
 * Created by Alex Iachimov on 5/6/2016.
 */
public class Calculations {

    public int OnCalcGeneralFormula(int height,int weight,int age,String sex,String lifeStyle,String goal){
        double preResult = 0;
        int resultCalories = 0;
        double metabolism = 0.0;
        /*Для мужчин*/
        if(sex.equalsIgnoreCase("male")){
            /*Для потери веса*/
            if(goal.equalsIgnoreCase("Weight loss")){
                /*Если пассивный образ жизни*/
                if(lifeStyle.equalsIgnoreCase("Passive")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.2 * 0.8;
                    resultCalories = (int) preResult;

                }
                 /*Если менее активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Little activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.375 * 0.8;
                    resultCalories = (int) preResult;

                }
                /*Если средне активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.55 * 0.8;
                    resultCalories = (int) preResult;

                }
                /*Если высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("High activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.725 * 0.8;
                    resultCalories = (int) preResult;
                }
                /*Если очень высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.9 * 0.8;
                    resultCalories = (int) preResult;

                }
            }
            /*Для набора веса*/
            else if (goal.equalsIgnoreCase("Weight set")){
                                /*Если пассивный образ жизни*/
                if(lifeStyle.equalsIgnoreCase("Passive")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.2 * 1.2;
                    resultCalories = (int) preResult;

                }
                 /*Если менее активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Little activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.2 * 1.375;
                    resultCalories = (int) preResult;
                }
                /*Если средне активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.2 * 1.55;
                    resultCalories = (int) preResult;
                }
                /*Если высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("High activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.2 * 1.725;
                    resultCalories = (int) preResult;
                }
                /*Если очень высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("ery high activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1.2 * 1.9;
                    resultCalories = (int) preResult;
                }
            }
            /*Для сохранения веса*/
            else if (goal.equalsIgnoreCase("Saving weight")){
                                /*Если пассивный образ жизни*/
                if(lifeStyle.equalsIgnoreCase("Passive")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1 * 1.2;
                    resultCalories = (int) preResult;
                }
                 /*Если менее активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Little activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1 * 1.375;
                    resultCalories = (int) preResult;
                }
                /*Если средне активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1 * 1.55;
                    resultCalories = (int) preResult;
                }
                /*Если высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("High activity")){
                    metabolism = 10* weight+6.25*height-5*age+5;
                    preResult = metabolism * 1 * 1.725;
                    resultCalories = (int) preResult;
                }
                /*Если очень высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1 * 1.9;
                    resultCalories = (int) preResult;
                }
            }
        /*Для женщин*/
        }else if (sex.equalsIgnoreCase("female")){
            /*Для потери веса*/
            if(goal.equalsIgnoreCase("Weight loss")){
                /*Если пассивный образ жизни*/
                if(lifeStyle.equalsIgnoreCase("Passive")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.2 * 0.8;
                    resultCalories = (int) preResult;

                }
                 /*Если менее активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Little activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.375 * 0.8;
                    resultCalories = (int) preResult;

                }
                /*Если средне активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.55 * 0.8;
                    resultCalories = (int) preResult;

                }
                /*Если высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("High activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.725 * 0.8;
                    resultCalories = (int) preResult;
                }
                /*Если очень высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.9 * 0.8;
                    resultCalories = (int) preResult;

                }
            }
            /*Для набора веса*/
            else if (goal.equalsIgnoreCase("Weight set")){
                                /*Если пассивный образ жизни*/
                if(lifeStyle.equalsIgnoreCase("Passive")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.2 * 1.2;
                    resultCalories = (int) preResult;

                }
                 /*Если менее активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Little activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.2 * 1.375;
                    resultCalories = (int) preResult;
                }
                /*Если средне активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.2 * 1.55;
                    resultCalories = (int) preResult;
                }
                /*Если высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("High activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.2 * 1.725;
                    resultCalories = (int) preResult;
                }
                /*Если очень высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1.2 * 1.9;
                    resultCalories = (int) preResult;
                }
            }
            /*Для сохранения веса*/
            else if (goal.equalsIgnoreCase("Saving weight")){
                                /*Если пассивный образ жизни*/
                if(lifeStyle.equalsIgnoreCase("Passive")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1 * 1.2;
                    resultCalories = (int) preResult;
                }
                 /*Если менее активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Little activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1 * 1.375;
                    resultCalories = (int) preResult;
                }
                /*Если средне активный образ жизни*/
                else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1 * 1.55;
                    resultCalories = (int) preResult;
                }
                /*Если высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("High activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1 * 1.725;
                    resultCalories = (int) preResult;
                }
                /*Если очень высокая активность*/
                else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    metabolism = 10* weight+6.25*height-5*age-161;
                    preResult = metabolism * 1 * 1.9;
                    resultCalories = (int) preResult;
                }
            }
        }

        return resultCalories;
    }

    public int OnCalcHarrisBenediktFormula(int height,int weight,int age,String sex,String lifeStyle,String goal){
        int calories = 0;
        double caloriesDouble = 0;
            if(sex.equalsIgnoreCase("male")){
                caloriesDouble = 66.5+13.75*weight+5.003*height-6.775;
                calories = (int)caloriesDouble;
                return calories;
            }else if(sex.equalsIgnoreCase("female")){
                caloriesDouble = 65.1+9.53*weight+1.5*height-4.676;
                calories = (int)caloriesDouble;
                return calories;
            }
        return calories;
    }

    public int OnCalcharrisBenediktNewFormula(int height,int weight,int age,String sex,String lifeStyle,String goal){

        int calories = 0;
        double caloriesDouble = 0;
        if(sex.equalsIgnoreCase("male")){
            caloriesDouble = 88.362+(13.397*weight)+(4.799*height)-(5.677*age);
            calories = (int)caloriesDouble;
            return calories;
        }else if(sex.equalsIgnoreCase("female")){
            caloriesDouble = 447.593+(9.247*weight)+(3.098*height)-(4.33*age);
            calories = (int)caloriesDouble;
            return calories;
        }
        return calories;
    }

    public int OnCalcWohFormula(int height,int weight,int age,String sex,String lifeStyle,String goal){

        int calories = 0;
        double caloriesDouble;
        if(sex.equalsIgnoreCase("female")){

            if(age<=30){
                if (lifeStyle.equalsIgnoreCase("Passive")){
                    caloriesDouble = (0.062*weight+2.036)*240*1.375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Little Activity")){
                    caloriesDouble = (0.062*weight+2.036)*240*1.4625;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    caloriesDouble = (0.062*weight+2.036)*240*1.550;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("High activity")){
                    caloriesDouble = (0.062*weight+2.036)*240*1.6375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    caloriesDouble = (0.062*weight+2.036)*240*1.9;
                    calories =(int)caloriesDouble;
                }


            }else if (age>30&&age<61){
                if (lifeStyle.equalsIgnoreCase("Passive")){
                    caloriesDouble = (0.034*weight+3.538)*240*1.375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Little Activity")){
                    caloriesDouble = (0.034*weight+3.538)*240*1.4625;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    caloriesDouble = (0.034*weight+3.538)*240*1.550;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("High activity")){
                    caloriesDouble = (0.034*weight+3.538)*240*1.6375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    caloriesDouble = (0.034*weight+3.538)*240*1.9;
                    calories =(int)caloriesDouble;
                }
            }else  if (age >61){
                if (lifeStyle.equalsIgnoreCase("Passive")){
                    caloriesDouble = (0.038*weight+2.755)*240*1.375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Little Activity")){
                    caloriesDouble = (0.038*weight+2.755)*240*1.4625;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    caloriesDouble = (0.038*weight+2.755)*240*1.550;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("High activity")){
                    caloriesDouble = (0.038*weight+2.755)*240*1.6375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    caloriesDouble = (0.038*weight+2.755)*240*1.9;
                    calories =(int)caloriesDouble;
                }
            }

        }else if(sex.equalsIgnoreCase("male")){

            if(age<=30){
                if (lifeStyle.equalsIgnoreCase("Passive")){
                    caloriesDouble = (0.063*weight+2.896)*240*1.375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Little Activity")){
                    caloriesDouble = (0.063*weight+2.896)*240*1.4625;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    caloriesDouble = (0.063*weight+2.896)*240*1.550;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("High activity")){
                    caloriesDouble = (0.063*weight+2.896)*240*1.6375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    caloriesDouble = (0.063*weight+2.896)*240*1.9;
                    calories =(int)caloriesDouble;
                }


            }else if (age>30&&age<61){
                if (lifeStyle.equalsIgnoreCase("Passive")){
                    caloriesDouble = (0.484*weight+3.653)*240*1.375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Little Activity")){
                    caloriesDouble = (0.484*weight+3.653)*240*1.4625;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    caloriesDouble = (0.484*weight+3.653)*240*1.550;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("High activity")){
                    caloriesDouble = (0.484*weight+3.653)*240*1.6375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    caloriesDouble = (0.484*weight+3.653)*240*1.9;
                    calories =(int)caloriesDouble;
                }
            }else  if (age >61){
                if (lifeStyle.equalsIgnoreCase("Passive")){
                    caloriesDouble = (0.491*weight+2.459)*240*1.375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Little Activity")){
                    caloriesDouble = (0.491*weight+2.459)*240*1.4625;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Middle activity")){
                    caloriesDouble = (0.491*weight+2.459)*240*1.550;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("High activity")){
                    caloriesDouble = (0.491*weight+2.459)*240*1.6375;
                    calories =(int)caloriesDouble;
                }else if(lifeStyle.equalsIgnoreCase("Very high activity")){
                    caloriesDouble = (0.491*weight+2.459)*240*1.9;
                    calories =(int)caloriesDouble;
                }
            }


        }
        return calories;
    }


}
