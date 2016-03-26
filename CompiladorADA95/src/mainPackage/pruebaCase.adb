procedure Grade is
   Score : Integer;
   Letter: String;
begin 

   loop

      Put ("Enter a test score (0 to 100) -- ");

      -- We must test for EOF after prompt, because it
      -- blocks waiting for input.
      exit when End_Of_File;

      Get (Score);

      case Score is
         when 91 .. 100 => Letter := "A";
         when 81 ..  90 => Letter := "B";
         when 71 ..  80 => Letter := "C";
         when 61 ..  70 => Letter := "D";
         when others    => Letter := "F";
        -- when others    => Letter := "G";
      end case;

      Put ("A score of ");
      Put (Score);
      Put ("' is the letter grade '");
      Put (Letter);

   end loop;

end Grade;