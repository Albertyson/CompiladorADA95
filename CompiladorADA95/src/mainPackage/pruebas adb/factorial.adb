procedure programa is
	n:Integer;
	res:Integer;
	function factorial(num:Integer) return Integer is
	begin -- factorial
		if (n=0) then
			return 1;
		end if;
		return factorial(num-1)*factorial(num);
	end factorial;
begin -- programa
	put("Ingrese n: ");
	get(n);
	res:=factorial(n);
	put("Resultado: ");
	put(res);
end programa;