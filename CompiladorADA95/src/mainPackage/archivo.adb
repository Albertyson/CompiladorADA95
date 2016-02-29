--
-- Functions and procedures may be overloaded in Ada as in C++ and Java.
-- The rules for figuring out which method you are calling differ.
--
with Text_IO;
with Gnat.Io; use Gnat.Io;
procedure f4 is
   -- Output booleans.
   package Boolean_IO is new Text_Io.Enumeration_IO(Boolean);
   use Boolean_IO;

   -- Two versions of MM, which differ in their arguments.
   procedure MM(Width: Integer; Ch: Character := 'X') is
   begin
      for I in 1..Width loop
         Put(Ch);
      end loop;
      New_Line;
   end MM;
   procedure MM(Height: Integer) is
   begin
      for I in 1..Height loop
         Put_Line("X");
      end loop;
   end MM;

   -- Two versions of QQ which differ only in return type.
   function QQ(Str: String) return Boolean is
   begin
      return Str(1) = 'T';
   end QQ;
   function QQ(Str: String) return Integer is
   begin
      return Str'Length;
   end QQ;

   M: Integer;
   B: Boolean;
begin
   MM(5, '@');              -- Can distinquish from the two arguments.
   MM(Height => 4);         -- Can distinquish from the parameter name.

   M := QQ("Left Turn");    -- M is an integer.
   Put(M);
   New_Line;
   B := QQ("Blip");         -- B is boolean.
   Put(B);
   New_Line;
end f4;