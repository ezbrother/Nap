import java.util.*;

public class Nap {

    public static void main(String[] args) {

        int NumberOfTest=0;
        String[] schedules = new String[100];

        int[] StartTime = new int[100];
        int[] FinishTime = new int[100];
        int[] Term = new int[100];
        int[] TempResult = new int[100];
        int[] NapStartTime = new int[100];

        StartTime[0] = 600;
        FinishTime[0] = 600;



       Scanner s = new Scanner(System.in);

       // int NumberOfSchedules = s.nextInt();


        while (true){
            //Input Number of schedules
            String temp = s.nextLine();
            //If Input blank, finish this loop
            if (temp.equals("")){
                break;
            }else {
                //Input time and schedules.
                if (temp.length() < 4) {
                    int NumberOfSchedules = Integer.parseInt(temp);
                    for (int i = 0; i < NumberOfSchedules; i++) {
                        String Schedule = s.nextLine();
                        schedules[i] = Schedule;
                    }
                    //subtracting time to int data from string sentences.
                    for (int i = 0; i < NumberOfSchedules; i++) {
                        String start_hour1 = schedules[i].substring(0, 1);
                        String start_hour2 = schedules[i].substring(1, 2);
                        String start_miniute1 = schedules[i].substring(3, 4);
                        String start_miniute2 = schedules[i].substring(4, 5);
                        String end_hour1 = schedules[i].substring(6, 7);
                        String end_hour2 = schedules[i].substring(7, 8);
                        String end_miniute1 = schedules[i].substring(9, 10);
                        String end_miniute2 = schedules[i].substring(10, 11);


                        int s_hour1 = Integer.parseInt(start_hour1);
                        int s_hour2 = Integer.parseInt(start_hour2);
                        int s_miniute1 = Integer.parseInt(start_miniute1);
                        int s_miniute2 = Integer.parseInt(start_miniute2);
                        int e_hour1 = Integer.parseInt(end_hour1);
                        int e_hour2 = Integer.parseInt(end_hour2);
                        int e_miniute1 = Integer.parseInt(end_miniute1);
                        int e_miniute2 = Integer.parseInt(end_miniute2);


                        int s_hour = 10 * s_hour1 + s_hour2;
                        int s_miniute = 10 * s_miniute1 + s_miniute2;
                        int e_hour = 10 * e_hour1 + e_hour2;
                        int e_miniute = 10 * e_miniute1 + e_miniute2;

                        //              System.out.println(s_hour);
                        //              System.out.println(s_miniute);
                        //              System.out.println(e_hour);
                        //              System.out.println(e_miniute);

                        //Save schedule's start,finish time
                        StartTime[i + 1] = s_hour * 60 + s_miniute;
                        FinishTime[i + 1] = e_hour * 60 + e_miniute;

                        //              System.out.println(StartTime[i+1]);
                        //              System.out.println(FinishTime[i+1]);

                    }
                    StartTime[NumberOfSchedules + 1] = 1080;

                    //Find the term between each continuos schedules.
                    for (int i = 0; i < NumberOfSchedules + 1; i++) {
                        Term[i] = StartTime[i + 1] - FinishTime[i];
                        //               System.out.println(Term[i]);
                    }
                    //         for (int i=0; i <NumberOfSchedules+1;i++) {
                    //               System.out.println("d"+Term[i]);
                    //           }

                    //Find the Max term.
                    int max = Term[0];
                    int napstart = 0;
                    for (int i = 1; i < NumberOfSchedules + 1; i++) {
                        if (Term[i] >= max) {
                            max = Term[i];
                            napstart = i;
                        }
                    }

                    NapStartTime[NumberOfTest] = FinishTime[napstart];
                    TempResult[NumberOfTest] = max;
                    NumberOfTest++;

                    //System.out.println(TempResult[0]);
                    //System.out.println(NapStartTime[0]);
                }

            }

        }

        //Output
        for (int k = 0; k<NumberOfTest; k++ ) {
            //System.out.println(TempResult[k]);
            //System.out.println(NapStartTime[k]);
            int NapStartHour = NapStartTime[k]/60;
            int NapStartMiniute = NapStartTime[k]- NapStartHour*60;
            int ResultHour = TempResult[k]/60;
            int ResultMiniute = TempResult[k]- ResultHour*60;
            int day = k+1;

            if (NapStartMiniute==0){
                if (ResultHour == 0){
                    System.out.println("Day #"+day+": the longest nap starts at "+NapStartHour+":"+"00"+" and will last for "+ResultMiniute+" minutes.");
                }else{
                    System.out.println("Day #"+day+": the longest nap starts at "+NapStartHour+":"+"00"+" and will last for "+ResultHour+" hours and "+ResultMiniute+" minutes.");
                }
            } else {
                if (ResultHour == 0){
                    System.out.println("Day #"+day+": the longest nap starts at "+NapStartHour+":"+NapStartMiniute+" and will last for "+ResultMiniute+" minutes.");
                }else{
                    System.out.println("Day #"+day+"1: the longest nap starts at "+NapStartHour+":"+NapStartMiniute+" and will last for "+ResultHour+" hours and "+ResultMiniute+" minutes.");
                }
            }

        }

        s.close();
    }
}
