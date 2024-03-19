public class Main {
    public static void main(String[] args) {
        SimEnvironment simEnvironment = new SimEnvironment(0.3, 0.4, 0.3, 0.2);
        double time = 0;
        double endTime = 20;
        double timestep = 0.5;
        
        simEnvironment.printConcentrations();
        while (time < endTime) {
            simEnvironment.simulate(timestep);
            simEnvironment.printConcentrations();
            time += timestep;
        }
    }
}