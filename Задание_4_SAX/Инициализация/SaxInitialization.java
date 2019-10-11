package saxinitialization;

public class SaxInitialization {

    public static void main(String[] args) {
        tariffBuilder saxBuilder = new tariffBuilder();
        saxBuilder.buildSetStudents("tariffDocument.xml");
        System.out.println(saxBuilder.getTariffs());
    }

}
