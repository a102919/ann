package sample;

import javafx.scene.control.TextArea;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cellbody {
    public Map<Integer,Double> initW(){
        Map<Integer,Double> w = new HashMap<>();
        double w1 = (Math.random()*(1-0) + 0);
        double w2 = (Math.random()*(1-0) + 0);
        double w3 = (Math.random()*(1-0) + 0);
        double w4 = (Math.random()*(1-0) + 0);
        w.put(0,w1);
        w.put(1,w2);
        w.put(2,w3);
        w.put(3,w4);
        return w;
    }
    public List<List<Double>> initX(){
        List<List<Double>> x = new ArrayList<>();
        List<Double> x1 = new ArrayList();
        x1.add(1.0);
        x1.add(1.5);
        x1.add(0.5);
        x1.add(0.0);

        List<Double> x2 = new ArrayList();
        x2.add(-0.5);
        x2.add(1.0);
        x2.add(0.0);
        x2.add(1.5);

        List<Double> x3 = new ArrayList();
        x3.add(-1.0);
        x3.add(0.0);
        x3.add(-1.0);
        x3.add(-0.5);

        x.add(x1);
        x.add(x2);
        x.add(x3);

        return x;
    }

    public  Map<Integer,Double> train(Map<Integer, Double> w, List<List<Double>> x, double η, TextArea textOutput){
        List<Integer> compare = new ArrayList<>();
        List<Integer> oldcompare = new ArrayList<>();
        boolean run = true;
        do{

            oldcompare.clear();
            oldcompare.addAll(compare);
            compare.clear();
            int xprint = 1;
            for(List<Double> xi:x){
                int xiSize = xi.size();
                double wtx = 0;
                int sgn = 0;

                for(int i=0;i<xiSize;i++){
                    wtx += xi.get(i)*w.get(i);
                }
                if(wtx>0){
                    sgn = 1;
                }else {
                    sgn = -1;
                }
                textOutput.appendText("w"+xprint+" : ");
                for(int i=0;i<xiSize;i++){
                    double newW = w.get(i)+η*sgn*xi.get(i);
                    w.put(i,newW);
                    DecimalFormat df=new DecimalFormat("#.##");
                    String Strw=df.format(newW);
                    textOutput.appendText(" , "+Strw);
                }
                compare.add(sgn);
                textOutput.appendText("\nx"+xprint+" : "+sgn+"\n");
                xprint++;
            }
        }while (oldcompare == compare);
        return w;
    }
}
