import java.util.HashMap;

public class StepTracker {
    HashMap<Integer, int[]> stepsByMonth = new HashMap<>();
    int goalOfSteps = 10000;


    public void addDataToMap (int month, int day, int steps){
        int[] stepsByDay = new int[30];
        stepsByDay[day] = steps;
        stepsByMonth.put(month,stepsByDay);
    }

    void printStats(int month){
            int[] stepsByDay = new int[30];
            stepsByDay = stepsByMonth.get(month);
            for (int i = 0; i < stepsByDay.length; i++) {
                System.out.println((i + 1) + " день: " + stepsByDay[i] + ", ");
            }
    }


    double maxStepsPerMonth (int month) {
            int maxSteps = 0;
            int[] stepsByDay = new int[30];
            stepsByDay = stepsByMonth.get(month);
            for (int i = 0; i < stepsByDay.length; i++) {
                if (stepsByDay[i] > maxSteps) {
                    maxSteps = stepsByDay[i];
                }
            }
            return maxSteps;
        }


    int avgStepsByMonth (int month){
        int sumSteps = 0;
        int days = 0;
        int[] stepsByDay = new int[30];
        stepsByDay = stepsByMonth.get(month);
            for (int i = 0; i < stepsByDay.length; i++) {
                if (stepsByDay[i] != 0) {
                    sumSteps += stepsByDay[i];
                    days++;
                }
            }

        return sumSteps/30;
    }

    int sumOfStepsByMonth (int month) {
            int sumSteps = 0;
            int[] stepsByDay = new int[30];
            stepsByDay = stepsByMonth.get(month);
            for (int i = 0; i < stepsByDay.length; i++) {
                sumSteps += stepsByDay[i];
            }
            return sumSteps;
    }

    int bestSeriesOfGoal (int month){
        int[] stepsByDay = new int[30];
        stepsByDay= stepsByMonth.get(month);
        int bestSeries = 0;
        int series = 0;
        for (int i=0; i<stepsByDay.length;i++){
            if (stepsByDay[i]>=goalOfSteps){
                series++;
                if (stepsByDay[i+1]<goalOfSteps){
                    if (bestSeries<series){
                        bestSeries=series;
                    }
                    series = 0;
                }
            }
        }
        return bestSeries;
    }

    boolean isMapNotEmpty(int month) {
        if (stepsByMonth.get(month)!=null){
            return true;
        } else {
            return false;
        }
    }
}
