procedure f4 is

   procedure MM(Width: Integer) is
      I:integer;
   begin
      for I in 1..Width loop
         Put(Width);
      end loop;
      New_Line;
   end MM;
   procedure MM2(Height: Integer) is
      I:integer;
   begin
      for I in 1..Height loop
         Put_Line("X");
      end loop;
   end MM2;

   function QQ2(Str: String) return Integer is
   begin
      return Str;
      --return Str(1) = 'T';
   end QQ2;
   function QQ(Str: String) return Integer is
   begin
      return "Length del string es 3";
   end QQ;

   M: Integer;
   B: Boolean;
begin
   MM(5, "a");
   --MM(Height => 4);

   M := QQ("Left Turn");
   Put(M);
   New_Line;
   B := QQ("Blip");
   Put(B);
   New_Line;
end f4;