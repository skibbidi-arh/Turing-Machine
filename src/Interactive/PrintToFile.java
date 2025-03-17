package Interactive;

public class PrintToFile {
    private static PrintToFile ptf;
    public String totaldata="";

    private PrintToFile(){

    }

    public static PrintToFile getInstance(){
        if(ptf == null){
            ptf = new PrintToFile();
        }
        return ptf;
    }


    String answer="";
    String Question="";
    int TotalMarks;
    String QuestionType;
    public  void getdata(String Question,String answer){
       totaldata = totaldata+"\n"+Question;
       totaldata = totaldata+"\n"+answer;

    }
    public void getmarks(int marks){
        this.TotalMarks=marks;
    }
    public static void main(String[] args) {

    }
    public void printData(){
        System.out.println(totaldata);
    }

   public  String getTotaldata(){
        return totaldata;
    }

    public  void flashData(){
        totaldata="";
    }


}
