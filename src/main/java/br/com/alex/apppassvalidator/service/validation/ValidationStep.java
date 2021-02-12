package br.com.alex.apppassvalidator.service.validation;

public abstract class ValidationStep<T> {

	private ValidationStep<T> firstValidation;
    private ValidationStep<T> nextValidation;
    
    public abstract boolean validate(T toValidate);

    public ValidationStep<T> nextValidation(ValidationStep<T> nextValidation) {
        this.nextValidation = nextValidation;
        if(firstValidation == null){
        	this.firstValidation = this;
        }
        
        this.nextValidation.firstValidation = this.firstValidation;
        return this.nextValidation;
    }
    
    public ValidationStep<T> getFirst(){
    	return firstValidation;
    }

    protected boolean checkNext(T toValidate) {
        if (nextValidation == null) {
            return true;
        }

        return nextValidation.validate(toValidate);
    }
}