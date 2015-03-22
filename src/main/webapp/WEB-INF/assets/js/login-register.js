/**
 * Created by Valentin on 22/03/15.
 */

$(document).ready(function() {
    $('#registration-form').formValidation({
        framework: 'bootstrap',
        locale: 'fr_FR',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            nickname: {
                validators: {
                    notEmpty: true,
                    stringLength: {
                        min: 4,
                        max: 42
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Le pseudo ne peut comporter que des caractères alphanumériques'
                    },
                    threshold: 4,
                    remote: {
                        url: '/ajax/auth/check-username',
                        type: 'POST',
                        delay: 1000,
                        message: 'Ce nom d\'utilisateur est déjà pris !'
                    }
                }
            },
            firstname: {
                validators: {
                    notEmpty: true
                }
            },
            lastname: {
                validators: {
                    notEmpty: true
                }
            },
            email: {
                validators: {
                    notEmpty: true,
                    emailAddress: true,
                    threshold: 4,
                    remote: {
                        url: '/ajax/auth/check-email',
                        type: 'POST',
                        delay: 420,
                        message: 'Cette adresse email est déjà utilisée !'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {},
                    different: {
                        field: 'nickname',
                        message: 'Le mot de passe ne peut pas être identique au nom d\'utilisateur'
                    },
                    idential: 'passwordConfirmation',
                    stringLength: {
                        min: 4,
                        max: 42
                    }
                }
            },
            passwordConfirmation: {
                validators: {
                    identical: {
                        field: 'password'
                    }
                }
            }
        }
    });
});