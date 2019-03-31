$(document).ready(function () {

    clearError();

    $('#login').click(function (event) {

        event.preventDefault();
        var EMAIL = $("#inputEmail").val();
        var PASSWORD = $("#inputPass").val();

        $.ajax({

            type: "POST",
            url: "ModalLogin",
            data: {
                email: EMAIL,
                password: PASSWORD
            },
            success: function (response) {

                if (response.status === 'FAIL') {
                    showFormError(response.errorMessageList);
                } else {
                    //everything is O.K. user logged in successfully.
                    $('#exampleModal').modal('hide');
                    window.location.reload();
                }
            },
            error: function (ex) {
                console.log(ex);
            }
        });
    });

    var PasswordField = $('#inputPass');
    var EmailField = $('#inputEmail');
    var GeneralErrorField = $('#generalErrorMessage');

    function showFormError(errorVal) {
        //show error messages that comming from backend and change border to red.
        for (var i = 0; i < errorVal.length; i++) {
            if (errorVal[i].fieldName === 'EMAIL') {
                clearForm();
                EmailField.attr("placeholder", errorVal[i].message).css("border", " 1px solid red");
            } else if (errorVal[i].fieldName === 'PASSWORD') {
                PasswordField.val('');
                PasswordField.attr("placeholder", errorVal[i].message).css("border", " 1px solid red");
            } else if (errorVal[i].fieldName === 'FORM FAIL') {
                clearForm();
                GeneralErrorField.css("display", "block").html(errorVal[i].message);
            }
        }
    }

    //remove error warning tags and change tips
    function clearError() {
        //clear all and return it as default.
        $('#inputEmail').focus(function () {
            clearForm();
            EmailField.css("border", "1px solid lightgrey");
            EmailField.attr("placeholder", "Email адресс");
        });
        $('#inputPass').focus(function () {
            PasswordField.val('');
            PasswordField.css("border", "1px solid lightgrey");
            PasswordField.attr("placeholder", "Пароль");
        });
    }

    //clear fields and hide error tag.
    function clearForm() {
        EmailField.val('');
        PasswordField.val('');
        GeneralErrorField.css("display", "none");
    }

});