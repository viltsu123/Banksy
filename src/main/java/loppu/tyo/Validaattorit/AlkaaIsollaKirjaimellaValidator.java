package loppu.tyo.Validaattorit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlkaaIsollaKirjaimellaValidator implements ConstraintValidator <AlkaaIsollaKirjaimella, String> {

	public void initialize(AlkaaIsollaKirjaimella alkaaisollakirjaimella){
		
	}
	
	public boolean isValid(String value, ConstraintValidatorContext context){
		
		boolean r = false;
		
		if(value.matches("[A-z]{1,15}")){
			r = true;
		}
		return r;
		
		
	}
}
