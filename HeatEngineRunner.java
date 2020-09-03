import java.util.Scanner;
public class HeatEngineRunner
{
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter in the mass of the water in grams");
        double mass = reader.nextDouble();
        System.out.println("Enter the initial temperature, in Celsius");
        double initialTemp = reader.nextDouble();
        if (initialTemp < -273.14)
        {
            initialTemp = -273.14;
        }
        System.out.println("Enter the final temperature, in Celsius");
        double finalTemp = reader.nextDouble();
        if (finalTemp < -273.14)
        {
            finalTemp = -273.14;
        }
        
        String initalPhase = "liquid";
        if (initialTemp < 0)
        {
            initalPhase = "solid";
        }
        
        if (initialTemp > 100)
        {
            initalPhase = "vapor";
        }
        
        String finalPhase = "liquid";
        if (finalTemp < 0)
        {
           finalPhase = "solid"; 
        }
        
        if (finalTemp > 100)
        {
            finalPhase = "vapor"; 
        }
        
        if (initialTemp < 0)
        {
            initalPhase = "solid";
        }
        System.out.println("Mass: " + mass + "g");
        System.out.println("Starting Temperature: " + initialTemp + "C");
        System.out.println("Final Temperature: " + finalTemp + "C");
        
        boolean endothermic = false;
        
        if (finalTemp > initialTemp)
        {
            endothermic = true;
        }
    }
    
    public static double tempChangeSolid(double mass, double startTemp, double endTemp, String endPhase, boolean endothermic)
    {
        if (!endPhase.equals("solid"))
        {
            endTemp = 0;
        }
        double energyChange = mass*2.108*(endTemp-startTemp);
        round(energyChange);
        if(endothermic)
            {
                System.out.println("Heating (solid): " + energyChange + "kj");
            }
            else
            {
                System.out.println("Cooling (solid): " + energyChange + "kj");
            }
            
        return energyChange;
        
    }
    
    public static double tempChangeLiquid(double mass, double startTemp, double endTemp, String endPhase, boolean endothermic)
    {
        if (endPhase.equals("solid"))
        {
            endTemp = 0;
        }
        if (endPhase.equals("vapor"))
        {
            endTemp = 100;
        }
        double energyChange = mass*4.184*(endTemp-startTemp);
        round(energyChange);
        if(endothermic)
        {
            System.out.println("Heating (liquid): " + energyChange + "kj");
        }
        else
        {
            System.out.println("Cooling (liquid): " + energyChange + "kj");
        }   
        return energyChange;
        
    }
    
    public static double tempChangeVapor(double mass, double startTemp, double endTemp, String endPhase, boolean endothermic)
    {
        if (!endPhase.equals("vapor"))
        {
            endTemp = 100;
        }
        double energyChange = mass*1.996*(endTemp-startTemp);
        round(energyChange);
        if(endothermic)
            {
                System.out.println("Heating (vapor): " + energyChange + "kj");
            }
            else
            {
                System.out.println("Cooling (vapor): " + energyChange + "kj");
            }
            
        return energyChange;
        
    }
    
    public static double fusion (double mass, boolean endothermic)
    {
        double energyChange;
       
        if (endothermic)
        {
            energyChange = 0.333*mass;
            round(energyChange);
            System.out.println("Melting: " + energyChange + "kJ");
        }
        else
        {
            round(energyChange = -0.333*mass);
            System.out.println("Freezing: " + energyChange + "kJ");
        }
        return energyChange;
    }
    
    public static double vaporization (double mass, boolean endothermic)
    {
        double energyChange;
       
        if (endothermic)
        {
            energyChange = 0.333*mass;
            round(energyChange);
            System.out.println("Evaporation: " + energyChange + "kJ");
        }
        else
        {
            energyChange = -0.333*mass;
            round(energyChange);
            System.out.println("Condensation: " + energyChange + "kJ");
        }
        return energyChange;
    }
    public static double round(double x)
    {
        x *= 10;
        if(x > 0)
        {
             return (int)(x + 0.5)/10;
        }
        else
        {
            return (int)(x - 0.5)/10;
        }
    }
}
