// togglePassword.js

function togglePassword() {
    const passwordField = document.getElementById('password');
    const eyeIcon = document.getElementById('eye-icon');
    const eyeIconHidden = document.getElementById('eye-icon-hidden');

    if (passwordField.type === 'password') {
        passwordField.type = 'text';
        eyeIcon.style.display = 'none';
        eyeIconHidden.style.display = 'inline';
    } else {
        passwordField.type = 'password';
        eyeIcon.style.display = 'inline';
        eyeIconHidden.style.display = 'none';
    }
}



