public class SimEnvironment {
    // current concentrations of molecules
    double c[] = new double[4];
    // new concentrations of molecules
    double cNew[] = new double[4];
    // exchange rate of molecules
    private final double N = 1e-10;
    // degradation rate of molecules
    private final double KD = 1e-5;
    // protein production rate
    private final double BETA = 10;
    // data fitting parameter
    private final double THETA = 1;
    // rate of product molecules released from the gate cell
    private final double EPSILON = 1e+4;

    /**
     * Constructor: input different concentration values
     * @param inCellInputConc concentration of input molecules inside a cell
     * @param outCellInputConc concentration of input molecules in the extracellular environment
     * @param inCellOutputConc concentration of produced molecules inside a cell
     * @param outCellOutputConc concentration of released molecules from cells
     * */
    public SimEnvironment(double inCellInputConc, double outCellInputConc, double inCellOutputConc, double outCellOutputConc) {
        c[0] = inCellInputConc;
        c[1] = outCellInputConc;
        c[2] = inCellOutputConc;
        c[3] = outCellOutputConc;
    }

    //
    public void simulate(double ts) {
        // random value between 0.0 and 1.0 for new input molecules
        cNew[0] = Math.random();
        cNew[1] = c[1] + ts*(N*c[0] - KD*c[1]);
        cNew[2] = c[2] + ts*(BETA*Math.pow(c[1], N)/(1 + Math.pow(THETA*c[1], N)) - (KD+EPSILON)*c[2]);
        cNew[3] = c[3] + ts*(c[2]);
        // update the concentrations
        c = cNew;
    }

    // print the concentrations of molecules
    public void printConcentrations() {
        System.out.println("--- Concentrations ---");
        System.out.println("Input molecules inside a cell: " + c[0]);
        System.out.println("Input molecules in the extracellular environment: " + c[1]);
        System.out.println("Produced molecules inside a cell: " + c[2]);
        System.out.println("Released molecules from cells: " + c[3]);
    }
}
