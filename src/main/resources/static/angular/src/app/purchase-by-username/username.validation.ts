import { AbstractControl, ValidationErrors } from "@angular/forms";


export class UserNameValidators {


   static cannotContainSpace(control: AbstractControl): ValidationErrors | null {
   /*  nisam uspio preko metode indexOf(' ') */
    var inValid = new RegExp("[\\s]");
    var k = inValid.test(control.value as string);
       
    if (k)
            return { cannotContainSpace: true };

        return null;
    }
}