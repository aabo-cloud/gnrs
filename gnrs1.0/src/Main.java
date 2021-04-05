import edu.bjut.cs.gns.GuidEntry;

public class Main {

    public static void main(String[] args) throws Exception {

//        GuidEntry guidEntry = new GuidEntry("guidTest");
//        System.out.println("==================================");
//        System.out.println(guidEntry.toString());

        GuidEntry X = new GuidEntry("X");
        GuidEntry Y = new GuidEntry("Y");

        System.out.println(GuidEntry.arbitrateGuid(Y, X));



    }
}
