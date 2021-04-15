//V1A: Proficiencies Split Between Booleans and Strings, probably a mistake, make uniform String version in next work session

import java.util.*;

StringTokenizer original_skills = new StringTokenizer("1.Acrobatics 2.Arcana 3.Athletics 4.Deception 5...", " ");

//independent classes
public class PlayerCharacter 
{
    private String character_name;
    
    //create CharacterClass, background, and race classes
    private int character_xp;
}

public class CharacterClass 
{
    private String saving_throw_proficiencies;
    private String weapon_proficiencies;
    private String armor_proficiencies;
    
    private String skill_choice_list;
    private int max_skill_choices;
}

public class Background 
{
}

public class Race 
{
    private String traits = new String[];
}

//dependent classes
public class Proficiency 
{
    
    Hashtable boolean_proficiencies<Integer, String> = new Hashtable<Integer, String>();

    boolean_proficiencies.put("strength_saving_throws", false);

    boolean_proficiencies.put("athletics", false);


    boolean_proficiencies.put("dexterity_saving_throws", false);

    boolean_proficiencies.put("acrobatics", false);
    boolean_proficiencies.put("sleight_of_hand", false);
    boolean_proficiencies.put("stealth", false);


    boolean_proficiencies.put("constitution_saving_throws", false);


    boolean_proficiencies.put("intelligence_saving_throws", false);

    boolean_proficiencies.put("arcana", false);
    boolean_proficiencies.put("history", false);
    boolean_proficiencies.put("nature", false);
    boolean_proficiencies.put("religion", false);


    boolean_proficiencies.put("wisdom_saving_throws", false);

    boolean_proficiencies.put("insight", false);
    boolean_proficiencies.put("medicine", false);
    boolean_proficiencies.put("perception", false);
    boolean_proficiencies.put("survival", false);


    boolean_proficiencies.put("charisma_saving_throws", false);

    boolean_proficiencies.put("deception", false);
    boolean_proficiencies.put("intimidation", false);
    boolean_proficiencies.put("performance", false);
    boolean_proficiencies.put("persuasion", false);

    private String other_proficiencies;



    //boolean proficiency methods
    private boolean isBoolean(String proficiency_in_question) 
    {
        return boolean_proficiencies.contains(proficiency_in_question);
    }

    private boolean getBoolean(String proficiency_in_question)
    {
        if(isBoolean(proficiency_in_question))
        {
            return boolean_proficiencies.getKey(proficiency_in_question);
        }
    }

    private void setBooleanToTrue(String proficiency_in_question)
    {
        if(isBoolean(proficiency_in_question))
        {
            boolean_proficiencies.replace(proficiency_in_question, true);
        }
    }

    private void setBooleanToFalse(String proficiency_in_question)
    {
        if(isBoolean(proficiency_in_question))
        {
            boolean_proficiencies.replace(proficiency_in_question, false);
        }
    }


    //other proficiency methods
    private boolean isOther(String proficiency_in_question)
    {
        return !boolean_proficiencies.contains(proficiency_in_question);
    }

    private boolean otherContains(String proficiency_in_question)
    {
        return this.other_proficiencies.contains(proficiency_in_question);
    }

    private void appendToOther(String proficiency_in_question)
    {
        if(isOther(proficiency_in_question) && !otherContains(proficiency_in_question))
        {
            this.other_proficiencies += proficiency_in_question;
        }
    }


    private boolean isProficient(String proficiencyInQuestion) 
    {
        if(isBoolean(proficiencyInQuestion))
        {
            return getBoolean(proficiencyInQuestion);
        } 
        else
        {
            return otherContains(proficiencyInQuestion);
        }
    }

    private void giveProficiency(String proficiencyInQuestion)
    {
        if(!this.isProficient(proficiencyInQuestion)
        {
            this.setBooleanToTrue(proficiencyInQuestion);
            this.appendToOther(proficiencyInQuestion);
        } 
        else 
        {
            System.out.println("Already proficient with: " + proficiencyInQuestion + ".\n");
        }
    }

    private void removeProficiency(String proficiencyInQuestion)
    {
        if(this.isProficient(proficiencyInQuestion))
        {
            this.setBooleanToFalse(proficiencyInQuestion);
            if(otherContains(proficiencyInQuestion))
            {
                other_proficiencies.replace(proficiencyInQuestion, "");
            }
        }
        else
        {
            System.out.println("Already not proficient with: " + proficiencyInQuestion + ".\n";
    }
}

public class Spellcasting
{
    private boolean is_spellcaster;

    private String spellcasting_ability;

    private int spells_known;
    private int cantrips_known;

    Hashtable<String, Integer> spell_tier_slots = new Hashtable<String, Integer>();
    spell_tier_slots.put("1st", 0);
    spell_tier_slots.put("2nd", 0);
    spell_tier_slots.put("3rd", 0);
    spell_tier_slots.put("4th", 0);
    spell_tier_slots.put("5th", 0);
    spell_tier_slots.put("6th", 0);
    spell_tier_slots.put("7th", 0);
    spell_tier_slots.put("8th", 0);
    spell_tier_slots.put("9th", 0);
}

public class CharacterDetails