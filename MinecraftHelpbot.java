/* ***************************************
  @author    Abbas Alibhai
  @date      1 December 2020
  @version   1

    A program that help bot which can
    provide information about minecraft
    which can teach the user about it
    when they request for specific data,
    giving the user an experience of a
    help bot.
   ****************************************/
package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class MinecraftHelpbot {
    public static void main(String[] args) throws IOException, InterruptedException {
        minecrafthelp();
    }
    public static void minecrafthelp() throws IOException, InterruptedException {
        System.out.println("Hello! My name is Steve. I am your personal Minecraft Help Bot.");
        System.out.println("I know about all sorts of Minecraft related info.");
        System.out.println();
        TimeUnit.SECONDS.sleep(1);
        nav();
    }
    public static void nav() throws IOException, InterruptedException {
        String choose = inputString("What do you want to know about?\n A. Weapons & Tools in Minecraft\n B. Mobs in " +
                "Minecraft\n C. Exit Chatbot");
        if (choose.equals("A") | choose.equals("a") | choose.equals("Weapons & Tools in Minecraft"))
        {
            System.out.println("Alright so you want to know about Weapons and Tools in Minecraft");
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
            WeaponsTools();
        }
        else if (choose.equals("B") | choose.equals("b") | choose.equals("Mobs in Minecraft"))
        {
            System.out.println("Alright so you want to know about Mobs in Minecraft");
            System.out.println();
            mobsinfo[] mob = new mobsinfo[15];
            CreateMobs(mob);
        }
        else if (choose.equals("C") | choose.equals("c") | choose.equals("Types of Gameplay"))
        {
            try {
                MobsSuggestions();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void WeaponsTools() throws IOException, InterruptedException {
        final int numberweaponstools = 5;
        weaponstoolsinfo[] weaponstools = new weaponstoolsinfo[numberweaponstools];

        String weaponstools0name = "Sword";
        String weaponstools0type = "Weapon";
        String weaponstools0use = "attack mobs";
        weaponstoolsinfo w0 = CreateRecord(weaponstools0name, weaponstools0type, weaponstools0use);
        weaponstools[0] = w0;

        String weaponstools1name = "Axe";
        String weaponstools1type = "Weapon";
        String weaponstools1use = "attack mobs and also break trees to get logs";
        weaponstoolsinfo w1 = CreateRecord(weaponstools1name, weaponstools1type, weaponstools1use);
        weaponstools[1] = w1;

        String weaponstools2name = "Hoe";
        String weaponstools2type = "Tool";
        String weaponstools2use = "turn dirt into farmland";
        weaponstoolsinfo w2 = CreateRecord(weaponstools2name, weaponstools2type, weaponstools2use);
        weaponstools[2] = w2;

        String weaponstools3name = "Shovel";
        String weaponstools3type = "Tool";
        String weaponstools3use = "dig dirt and sand quickly";
        weaponstoolsinfo w3 = CreateRecord(weaponstools3name, weaponstools3type, weaponstools3use);
        weaponstools[3] = w3;

        String weaponstools4name = "Pick-axe";
        String weaponstools4type = "Tool";
        String weaponstools4use = "break most blocks";
        weaponstoolsinfo w4 = CreateRecord(weaponstools4name, weaponstools4type, weaponstools4use);
        weaponstools[4] = w4;

        String wtfilemade = inputString("Do you already have a Weapons & Tools List file made?\n A. Yes\n B. No");
        if (wtfilemade.equals("A") | wtfilemade.equals("a") | wtfilemade.equals("Yes") | wtfilemade.equals("yes"))
        {
            System.out.println("Alright. We're reading your updated file now");
            BufferedReader inputStream = new BufferedReader(new FileReader("Weapons & Tools List.txt"));
            String weaponstoolslist;
            while ((weaponstoolslist = inputStream.readLine()) != null)
            {
                //String weaponstoolslist = inputStream.readLine();
                System.out.println(weaponstoolslist);
            }
            inputStream.close();
        }
        else if (wtfilemade.equals("B") | wtfilemade.equals("b") | wtfilemade.equals("No") | wtfilemade.equals("no"))
        {
            PrintWriter outputStream = new PrintWriter(new FileWriter("Weapons & Tools List.txt"));
            outputStream.println("All the Weapons & Tools in Minecraft:");
            for (int k = 0; k <= 4; k++) {
                outputStream.println(getName(weaponstools[k]));
            }
            outputStream.close();

            BufferedReader inputStream = new BufferedReader(new FileReader("Weapons & Tools List.txt"));
            String weaponstoolslist;
            while ((weaponstoolslist = inputStream.readLine()) != null) {
                //String weaponstoolslist = inputStream.readLine();
                System.out.println(weaponstoolslist);
            }

            inputStream.close();
            TimeUnit.SECONDS.sleep(1);

            System.out.println();
            System.out.println("A file of the list of the above weapons and tools has been made for you. Feel free to add " +
                    "new weapons and tools to the list when you have closed the program.");
            System.out.println();
            TimeUnit.SECONDS.sleep(1);
        }

        String choose2 = inputString("Do you want information about a specific weapon or tool?\n A. Search for weapon" +
                "\n B. Go back to Navigation");
        if (choose2.equals("A") | choose2.equals("a")) {
            int searchnumber2 = inputInt("How many weapons or tools do you want to know about?");
            for (int i = 1; i <= searchnumber2; i++) {
                String weapontoolname = inputString("What weapon or tool are you looking for?");
                System.out.println();
                final int weapontoolnumber = 5;
                for (int m = 0; m <= weapontoolnumber; m++)
                    if (weapontoolname.equals(getName(weaponstools[m]))) {
                        System.out.println(WeaponsToolsToString(weaponstools[m]));
                        System.out.println();
                        break;
                    } else if ((!weapontoolname.equals(getName(weaponstools[0]))) &&
                            (!weapontoolname.equals(getName(weaponstools[1]))) &&
                            (!weapontoolname.equals(getName(weaponstools[2]))) &&
                            (!weapontoolname.equals(getName(weaponstools[3]))) &&
                            (!weapontoolname.equals(getName(weaponstools[4]))))
                    {
                        System.out.println("The weapon or took you have searched for either doesn't exist or I don't know " +
                                "about it yet.\n");
                        break;
                    }
            }
            WeaponsTools();
        }
        else if (choose2.equals("B") | choose2.equals("b")) {
            System.out.println();
            nav();
        }
    }
    public static void CreateMobs(mobsinfo[] mob) throws IOException, InterruptedException {
        mob[0] = new mobsinfo();
        mob[0].name = "Zombie";
        mob[0].type = "Hostile";
        mob[0].description = "Zombies are green beings with cyan shirts and purple pants.";
        mob[0].abundance = "Common";

        mob[1] = new mobsinfo();
        mob[1].name = "Creeper";
        mob[1].type = "Hostile";
        mob[1].description = "Creepers are lime-green beings with four legs and explode you go next to them.";
        mob[1].abundance = "Common";

        mob[2] = new mobsinfo();
        mob[2].name = "Skeleton";
        mob[2].type = "Hostile";
        mob[2].description = "Skeletons are gray beings which always have a bows with them.";
        mob[2].abundance = "Common";

        mob[3] = new mobsinfo();
        mob[3].name = "Pillager";
        mob[3].type = "Hostile";
        mob[3].description = "Pillagers are gray beings with brown shirts and pants who carry crossbows.";
        mob[3].abundance = "Rare";

        mob[4] = new mobsinfo();
        mob[4].name = "Ender Dragon";
        mob[4].type = "Hostile";
        mob[4].description = "Ender Dragons are found in the End. They are large and black with purple eyes and wings.";
        mob[4].abundance = "Rare";

        mob[5] = new mobsinfo();
        mob[5].name = "Cow";
        mob[5].type = "Passive";
        mob[5].description = "Cows are brown and white beings with four legs.";
        mob[5].abundance = "Common";

        mob[6] = new mobsinfo();
        mob[6].name = "Sheep";
        mob[6].type = "Passive";
        mob[6].description = "Sheeps in Minecraft are relatively the same except their wool is often different. " +
                "White, black and gray wool sheep are common whereas brown and pink wool sheep are rare.";
        mob[6].abundance = "Common";

        mob[7] = new mobsinfo();
        mob[7].name = "Chicken";
        mob[7].type = "Passive";
        mob[7].description = "Chickens are small beings with white, orange and red faces. They often lay eggs.";
        mob[7].abundance = "Common";

        mob[8] = new mobsinfo();
        mob[8].name = "Villager";
        mob[8].type = "Passive";
        mob[8].description = "Villagers are brown beings with brown shirts and pants. Some variations come with jobs.";
        mob[8].abundance = "Rare";

        mob[9] = new mobsinfo();
        mob[9].name = "Turtle";
        mob[9].type = "Passive";
        mob[9].description = "Turtles are green beings with green shells often found near sandbanks.";
        mob[9].abundance = "Rare";

        mob[10] = new mobsinfo();
        mob[10].name = "Wolf";
        mob[10].type = "Neutral";
        mob[10].description = "Wolves are gray beings with four legs. You can tame them, but if you hit them, they attack.";
        mob[10].abundance = "Rare";

        mob[11] = new mobsinfo();
        mob[11].name = "Spider";
        mob[11].type = "Neutral";
        mob[11].description = "Spiders are large black beings with eight legs which often leave string when killed.";
        mob[11].abundance = "Common";

        mob[12] = new mobsinfo();
        mob[12].name = "Enderman";
        mob[12].type = "Neutral";
        mob[12].description = "Enderman are black beings followed by purple dust. Looking at them will make them attack.";
        mob[12].abundance = "Rare";

        mob[13] = new mobsinfo();
        mob[13].name = "Iron Golem";
        mob[13].type = "Neutral";
        mob[13].description = "Iron Golems are large, strong gray beings who often protect village.";
        mob[13].abundance = "Rare";

        mob[14] = new mobsinfo();
        mob[14].name = "Bee";
        mob[14].type = "Neutral";
        mob[14].description = "Bees are small yellow and black striped beings with wings, often found near beehives.";
        mob[14].abundance = "Rare";

        Mobs(mob);
    }
    public static void Mobs(mobsinfo[] mob) throws IOException, InterruptedException{
        String choose = inputString("Are you looking for a specific mob or mobs? Or do you want to see a list of all" +
                " the mobs?\n A. Search for mobs.\n B. See a list of mobs\n C. Go back to Navigation");
        if (choose.equals("A") | choose.equals("a"))
        {
            int searchnumber = inputInt("How many mobs do you want to know about?");
            for (int i = 1; i <= searchnumber; i++)
            {
                String mobname = inputString ("What mob are you looking for?");
                System.out.println();
                final int mobnumber = 16;
                for (int j = 0; j < mobnumber; j++)
                    if (mobname.equals(mob[j].name))
                    {
                        System.out.println(mob[j].name + ":");
                        System.out.println("This Mob is a "+ mob[j].type + " mob.");
                        System.out.println(mob[j].description);
                        System.out.println("This Mob is " + mob[j].abundance + ".\n");
                        break;
                    }
                    else if ((!mobname.equals(mob[1].name)) && (!mobname.equals(mob[2].name)) &&
                            (!mobname.equals(mob[3].name)) && (!mobname.equals(mob[4].name)) &&
                            (!mobname.equals(mob[5].name)) && (!mobname.equals(mob[6].name)) &&
                            (!mobname.equals(mob[7].name)) && (!mobname.equals(mob[8].name)) &&
                            (!mobname.equals(mob[9].name)) && (!mobname.equals(mob[10].name)) &&
                            (!mobname.equals(mob[11].name)) && (!mobname.equals(mob[12].name)) &&
                            (!mobname.equals(mob[13].name))  && (!mobname.equals(mob[14].name)))
                    {
                        System.out.println("The mob you have searched for either doesn't exist or I don't know " +
                                "about it yet.\n");
                        break;
                    }
            }
            System.out.println();
            CreateMobs(mob);
        }
        if (choose.equals("B") | choose.equals("b"))
        {
            final int mobnumber = 15;
            for (int k = 0; k < mobnumber; k++)
            {
                System.out.println((k+1) +". " + mob[k].name);
            }
            System.out.println();
            Mobs(mob);
        }
        if (choose.equals("C") | choose.equals("c"))
        {
            System.out.println();
            nav();
        }
    }
    public static void MobsSuggestions() throws IOException
    {
        String wtfilemade = inputString("Do you already have a Mobs Suggestions List file made?\n A. Yes\n B. No");
        if (wtfilemade.equals("A") | wtfilemade.equals("a") | wtfilemade.equals("Yes") | wtfilemade.equals("yes"))
        {
            System.out.println("Alright. We're reading your file now");
            BufferedReader inputStream = new BufferedReader(new FileReader("Mobs Suggestions List.txt"));
            String mobssuggestionslist;
            while ((mobssuggestionslist = inputStream.readLine()) != null)
            {
                System.out.println(mobssuggestionslist);
            }
            inputStream.close();

            String wtfilemore = inputString("Would you like to add more suggestions?\n A. Yes\n B. No");
            if (wtfilemore.equals("A") | wtfilemore.equals("a") | wtfilemore.equals("Yes") | wtfilemore.equals("yes"))
            {
                String current;
                int mobcount = inputInt("Enter the number of mobs you would like to add:");
                String[] mobtext = new String[mobcount];
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the mobs one by one:"); //User is entering the strings and they are stored in an array
                for (int i = 0; i < mobcount; i++) {
                    mobtext[i] = scan1.nextLine();
                }
                scan1.close();
                //Sorting the strings
                for (int i = 0; i < mobcount; i++) {
                    for (int j = i + 1; j < mobcount; j++) {
                        if (mobtext[i].compareTo(mobtext[j]) > 0) {
                            current = mobtext[i];
                            mobtext[i] = mobtext[j];
                            mobtext[j] = current;
                        }
                    }
                }
                //Displaying the strings after sorting them based on alphabetical order
                System.out.print("Strings in Sorted Order: ");
                for (int i = 0; i <= mobcount - 1; i++) {
                    System.out.print(mobtext[i]);
                    if (i <= mobcount - 2) {
                        System.out.print(", ");
                    }
                }
                PrintWriter outputStream = new PrintWriter(new FileWriter("Mobs Suggestions List.txt", true));
                outputStream.println("");
                for (int i = 0; i <= mobcount - 1; i++) {
                    outputStream.println(mobtext[i]);
                }
                outputStream.close();
                Goodbye();
            }
        }
        else if (wtfilemade.equals("B") | wtfilemade.equals("b") | wtfilemade.equals("No") | wtfilemade.equals("no"))
        {
            String current;
            int mobcount = inputInt("To improve our services next time, enter the number of mobs you would like to know about:");
            if (mobcount == 0)
            {
                Goodbye();
            }
            else {
                String[] mobtext = new String[mobcount];
                Scanner scan1 = new Scanner(System.in);
                System.out.println("Enter the mobs one by one:"); //User is entering the strings and they are stored in an array
                for (int i = 0; i < mobcount; i++) {
                    mobtext[i] = scan1.nextLine();
                }
                scan1.close();
                //Sorting the strings
                for (int i = 0; i < mobcount; i++) {
                    for (int j = i + 1; j < mobcount; j++) {
                        if (mobtext[i].compareTo(mobtext[j]) > 0) {
                            current = mobtext[i];
                            mobtext[i] = mobtext[j];
                            mobtext[j] = current;
                        }
                    }
                }
                //Displaying the strings after sorting them based on alphabetical order
                System.out.print("Strings in Sorted Order: ");
                for (int i = 0; i <= mobcount - 1; i++) {
                    System.out.print(mobtext[i]);
                    if (i <= mobcount - 2) {
                        System.out.print(", ");
                    }
                }
                PrintWriter outputStream = new PrintWriter(new FileWriter("Mobs Suggestions List.txt"));
                outputStream.print("The mobs you requested to be added are:\n");
                for (int i = 0; i <= mobcount - 1; i++) {
                    outputStream.print(mobtext[i]);
                    if (i <= mobcount - 2) {
                        outputStream.println("");
                    }
                }
                outputStream.close();
                Goodbye();
            }
        }
    }

    public static void Goodbye() {
        System.out.println();
        System.out.println("Thanks for inquiring about Minecraft. Have a nice day!");
        System.exit(0);
    }
    public static String inputString(String message)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String answer = scanner.nextLine();
        return answer;
    }
    public static int inputInt(String message)
    {
        String answer = inputString(message);
        return Integer.parseInt(answer);
    }
    public static String WeaponsToolsToString (weaponstoolsinfo w)
    {
        String message = "The name of the item is: " + getName(w) + "\nThis item is commonly used as a "
                + getType(w) + "\nThis item is used to " + getUse(w);
        return message;
    }
    public static String getName (weaponstoolsinfo w)
    {
        return w.name;
    }

    public static String getType (weaponstoolsinfo w)
    {
        return w.type;
    }

    public static String getUse (weaponstoolsinfo w)
    {
        return w.use;
    }
    public static weaponstoolsinfo CreateRecord (String name, String type, String use)
    {
        weaponstoolsinfo w = new weaponstoolsinfo();
        w.name = name;
        w.type = type;
        w.use = use;
        return w;
    }
}
class mobsinfo
{
    String name;
    String type;
    String description;
    String abundance;
}
class weaponstoolsinfo
{
    String name;
    String type;
    String use;
}