import java.text.DecimalFormat;
import java.util.*;

public class Sam{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        DecimalFormat df=new DecimalFormat("######0.00");
        System.out.println("请输入学生的人数：");
        int renshu=in.nextInt();
        System.out.println("请输入课程的数目：");
        int courseNum=in.nextInt();
        String[] name=new String[renshu];
        String[] course=new String[courseNum];
        double[][] number=new double[renshu][courseNum];
        double[] sum=new double[renshu];
        double[] avg=new double[renshu];
        String[] str=new String[renshu];
        for(int i=0;i<courseNum;i++){
            System.out.println("请定义第"+(i+1)+"门课程的名字：");
            course[i]=in.next();
        }
        for(int i=0;i<renshu;i++){
            double S=0;
            System.out.println("请输入学生的名字：");
            name[i]=in.next();
            String str11="";
            for(int j=0;j<courseNum;j++){
                System.out.println("请输入学生"+name[i]+"的"+course[j]+"成绩：");
                number[i][j]=in.nextDouble();
                S+=number[i][j];
                str11+=df.format(number[i][j])+"\t";
            }
            sum[i]=S;
            avg[i]=S/courseNum;
            str[i]=name[i]+"\t"+str11+df.format(sum[i])+"\t"+df.format(avg[i]);
        }
        for(int i=0;i<renshu-1;i++){
            for(int j=0;j<renshu-1;j++){
                if(sum[j]<sum[j+1]){
                    double t1=sum[j];	String t2=str[j];
                    sum[j]=sum[j+1];	str[j]=str[j+1];
                    sum[j+1]=t1;		str[j+1]=t2;
                }
            }
        }
        System.out.print("学生");
        for(int i=0;i<courseNum;i++){
            System.out.print("\t"+course[i]);
        }
        System.out.print("\t\t总分\t平均分\t排行榜\n");
        for(int i=0;i<renshu;i++){
            System.out.println(str[i]+"\t第"+(i+1)+"名");
        }
        in.close();
    }
}