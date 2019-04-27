/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

/**
 *
 * @author amcfire
 */
public class BusinessLogic {
    private static int[] answers = {9, 8, 36, 13, 32};
    private static String[] series = {"3, 1, 4, 1, 5","1, 1, 2, 3, 5","1, 4, 9, 16, 25","2, 3, 5, 7, 11","1, 2, 4, 8, 16"};
    private static String[] hints = {"PI","Fibonacci","Square","Primes","pow"};
    private String serie="";
    private int indexSerie=-1;
    private int answerSerie=-1;
    private int actualScore=0;
    private int actualTry=0;
    private String actualhint="";
    private String SactualScore="0";
    private String Message="";
    private boolean flagAnswer=true;

    public BusinessLogic (String SSelectedAnswer){
        String SelectedSerie=series[0];
        String SPrevScore="0";
        int nTry = 0;
        this.serie=SelectedSerie;
        for(int c=0;c<series.length;c++){
            if(series[c].equals(SelectedSerie)){
                this.indexSerie=c;
                this.answerSerie=answers[c];
            }
        }
        this.actualScore = (int)Integer.valueOf(SPrevScore);
        int SelectedAnswer = (int)Integer.valueOf(SSelectedAnswer);
        if(answerSerie==SelectedAnswer){
            actualScore = actualScore+GetScoreQuestion(nTry);
            SactualScore = ""+actualScore;
            Message = "Good!!!";
            flagAnswer=true;
        }else{
            if(actualTry<=2){
                actualTry = actualTry+1;
                Message = "Your last answer was not correct! Please try again";
                flagAnswer=false;
            }else{
                actualTry = 3;
                Message = "No more attempts";
                flagAnswer=true;                
            }
        }
    }
    
    public BusinessLogic (String SelectedSerie, String SSelectedAnswer, String SPrevScore, String STry){
        this.serie=SelectedSerie;
        for(int c=0;c<series.length;c++){
            if(series[c].equals(SelectedSerie)){
                this.indexSerie=c;
                this.answerSerie=answers[c];
            }
        }
        this.actualScore = (int)Integer.valueOf(SPrevScore);
        int nTry = (int)Integer.valueOf(STry);
        int SelectedAnswer = (int)Integer.valueOf(SSelectedAnswer);
        if(answerSerie==SelectedAnswer){
            actualScore = actualScore+GetScoreQuestion(nTry);
            SactualScore = ""+actualScore;
            Message = "Good!!!";
            flagAnswer=true;
        }else{
            if(actualTry<=2){
                actualTry = actualTry+1;
                Message = "Your last answer was not correct! Please try again";
                flagAnswer=false;
            }else{
                actualTry = 3;
                Message = "No more attempts";
                flagAnswer=true;                
            }
        }
    }
        
    public String GetSerie(){
        return this.serie;
    }
    
    public String GetNextSerie(){
        if(flagAnswer){
            if(GetNextIndex()<0){
                return series[0];
            }
            return series[GetNextIndex()];
        }else
        {
            if(actualTry>=2){
                if(GetNextIndex()<0){
                    return series[GetNextIndex()];
                }
            }else{
                if(GetNextIndex()<0){
                    return series[GetIndex()];
                }                
            }
        }
        return series[GetIndex()];         
    }
   
    public int GetIndex(){
        return this.indexSerie;
    }

    public int GetNextIndex(){
        if((this.indexSerie+1)>=series.length){
            return -1;
        }
        return (this.indexSerie+1);
    }
    
    public int GetAnswer(){
        return this.answerSerie;
    }
    
    public String GetSAnswer(){
        return (""+this.answerSerie);
    }
    
    public String GetHint(){
        if(flagAnswer){
            actualhint=hints[GetNextIndex()];
        }else{
            actualhint=hints[indexSerie];      
        }
        return this.actualhint;
    }
    
    public String GetActualScore(){
        return this.SactualScore;
    }
    
    public String GetSeriesSize(){
        return (""+series.length);
    }
    
    public boolean GetPassNextQuestion(){
        if((actualTry<=2)&&!flagAnswer){
            return false;
        }
        return true;
    }
    
    public String GetTry(){
        if((actualTry==3)&&(flagAnswer)){
            return "0";
        }
        return (""+actualTry);
    }
    
    public int GetScoreQuestion(int v){
        int ans;
        if(v==0){
            ans=10;
        }else if(v==1){
            ans=5;
        }else if(v==2){
            ans=2;
        }else{
            ans=0;
        }
        return ans;
    }
    
    public boolean GetFlagAnswer(){
        return flagAnswer;
    }
}
