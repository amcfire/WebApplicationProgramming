/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.cs472;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amcfire
 */
public class BeerExpert {
    List<pair> brands= new ArrayList<>();
   
    public List<String> getBrands(String c){
        brands.add(new pair("light","Denny Beer"));
        brands.add(new pair("light","Bud Light"));
        brands.add(new pair("amber","Rossi Beer"));
        brands.add(new pair("amber","Reb Club"));
        brands.add(new pair("brown","Poker"));
        brands.add(new pair("brown","Blue Star"));
        brands.add(new pair("dark","Dark Lorena"));
        brands.add(new pair("dark","Conga Special"));
        List<String> result=new ArrayList<>();
        for(pair p:brands){
            if(p.getBrand().equals(c)){
               result.add(p.getName());
            }
        }
        return result;
    }
    class pair{
        String brand;
        String name;

        pair(String b, String n){
            this.brand=b;
            this.name=n;
        }
        
        String getName(){
            return name;
        }
        
        String getBrand(){
            return brand;
        }
    }
}


            
