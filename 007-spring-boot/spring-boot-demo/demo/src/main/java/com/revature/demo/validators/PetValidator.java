package com.revature.demo.validators;

import com.revature.demo.entities.Pet;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PetValidator implements Validator {
    // configuring which class this validator applies to
    // will return true if the class is in fact Pet
    // false otherwise
    // this is used to determine which classes this validator can be applied to
    @Override
    public boolean supports(Class<?> clazz) {
        return Pet.class.equals(clazz);
    }

    // We can add custom validation logic:
    // target - is the option that we are checking
    // Errors is a special object that keeps track of any errors
    // that are encountered during validation
    @Override
    public void validate(Object target, Errors errors) {
        // Still have some built-in checks that we can use
        ValidationUtils.rejectIfEmpty(errors, "name", "name cannot be empty");
        // set up custom rules by inspecting the object directly:
        Pet pet = (Pet) target;
        if(pet.getFood().equals("chocolate")) {
            // manually reject this validation and give our reason:
            errors.rejectValue("food", "Pets can't eat chocolate");
        }
    }
}
