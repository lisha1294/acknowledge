/**
* when the supertypes of a class or interface provide multiple default 
* methods with the same signature, the Java compiler follows inheritance 
* rules to resolve the name conflict.
* Rule # 2:
* Methods that are already overridden by other candidates are ignored. 
* This circumstance can arise when supertypes share a common ancestor.
*/
interface Animal 
{
    public String identifyMyself() 
    {
        return "interface_animal";
    }
}

interface EggLayer extends Animal 
{
    public String identifyMyself() 
    {
        return "lay_eggs_extends_animal";
    }
}

interface FireBreather extends Animal 
{ 
    public String identifyMyself() 
    {
        return "fire_breather_extends_animal";
    }
}

/**
* The method Dragon.identifyMyself returns the string 
* "I am able to lay eggs.""
*/
public class Dragon implements EggLayer, FireBreather 
{
    public static void main (String... args) 
    {
        Dragon dragon = new Dragon();
        System.out.println(dragon.identifyMyself());
    }
}