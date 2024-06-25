document.addEventListener("DOMContentLoaded", function () {
    var form = document.querySelector("form");

    form.addEventListener("submit", function (event) {
        // Validate the form before submitting
        if (!validateForm()) {
            event.preventDefault(); // Prevent the form from submitting if validation fails
        }
    });

    function validateForm() {
        var isFormValid = true;

        // Reset previous error messages
        resetErrorMessages();

        // Validate Email
        var emailInput = document.getElementById("email");
        if (!validateEmail(emailInput.value)) {
            isFormValid = false;
        }

        // Validate Password
        var passwordInput = document.getElementById("password");
        if (!validateInput(passwordInput)) {
            isFormValid = false;
        }

        return isFormValid;
    }

    function resetErrorMessages() {
        // Remove previous error messages
        var errorMessages = document.querySelectorAll(".error-message");
        errorMessages.forEach(function (errorMessage) {
            errorMessage.remove();
        });
    }

    function validateInput(input) {
        if (input.value.trim() === "") {
            displayErrorMessage(input, "Bu alan zorunludur.");
            return false;
        }
        return true;
    }

    function validateEmail(email) {
        // Simple email validation using a regular expression
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(email)) {
            displayErrorMessage(document.getElementById("email"), "Geçerli bir e-posta adresi girin.");
            return false;
        }
        return true;
    }

    function displayErrorMessage(input, message) {
        // Display error message below the input field
        var errorMessage = document.createElement("p");
        errorMessage.className = "error-message";
        errorMessage.textContent = message;
        input.parentNode.appendChild(errorMessage);
    }
});