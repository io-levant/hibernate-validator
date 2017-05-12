/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */

package org.hibernate.validator.ext;


import java.lang.annotation.Annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.internal.engine.ValueContext;



/**
 * The {@link ConstraintValidatorExt} interface extends the JSR compliant {@link ConstraintValidator} one, adding the
 * capability to receive, at validation time, some valuable context informations: the current bean instance and the
 * current {@link ValueContext} object.
 * 
 * This interface can be used as a drop-in replacement for the {@link ConstraintValidator}.
 * 
 */
public interface ConstraintValidatorExt < A extends Annotation, T, B > extends ConstraintValidator < A, T >
{
	@Override
	default boolean isValid( T value, ConstraintValidatorContext context )
	{
		throw new RuntimeException(
			"Implementations of the " + ConstraintValidatorExt.class.getName( ) + " interface shall support only the new and improved isValid( T, ConstraintValidatorContext, ValueContext < T, B > ) method." );
	}

	boolean isValid( T value, ConstraintValidatorContext context, B bean, ValueContext < T, B > valueContext );
}
