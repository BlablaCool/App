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
                    notEmpty: {},
                    stringLength: {
                        min: 6,
                        max: 30
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'Le pseudo ne peut comporter que des caractères alphanumériques'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {},
                    emailAddress: {}
                }
            },
            password: {
                validators: {
                    notEmpty: {},
                    different: {
                        field: 'nickname',
                        message: 'Le mot de passe ne peut pas être identique au nom d\'utilisateur'
                    }
                }
            }
        }
    });
});