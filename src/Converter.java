public class Converter {
    double lengthOfStep = 0.75;
    double kalPerStep = 50;

    double trackerOfDist(int sumOfSteps) {
        return sumOfSteps*lengthOfStep;
        }

    double trackerOfKkal(int sumOfSteps){
        return sumOfSteps*kalPerStep/1000;
    }
}
