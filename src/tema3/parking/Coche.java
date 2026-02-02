package tema3.parking;

public class Coche extends Thread {
    String id;
    Supervisor supervisor;
    public Coche(String id, Supervisor supervisor) {
        this.id = id;
        this.supervisor = supervisor;
    }

    @Override
    public void run() {
        while (true) {
            try{
                if(id.endsWith("1")){
                    System.out.println();
                }
                supervisor.entra(this.id);
                Thread.sleep((long)(5000*Math.random())+2000);
                supervisor.sale(id);
                Thread.sleep((long)(5000*Math.random())+2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
