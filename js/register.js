document.addEventListener("DOMContentLoaded", function() {
    const formFullName = document.getElementById("fullname");
    const formEmail = document.getElementById("email");
    const formUsername = document.getElementById("username");
    const formPassword = document.getElementById("password");
    const formPhoneNumber = document.getElementById("phonenumber");
    
    // Thêm sự kiện lắng nghe cho form khi người dùng nhấn "Sign Up"
    const form = document.querySelector(".form-signup");
    
    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Ngăn chặn hành động mặc định của form
        register(); // Gọi hàm đăng ký
        this.reset(); // Reset form sau khi gửi
    });

    const BASE_URL = "http://localhost:8080";

    async function register() {
        try {
            const response = await fetch(`${BASE_URL}/api/v1/users`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    fullname: formFullName.value,
                    email: formEmail.value,
                    username: formUsername.value,
                    password: formPassword.value,
                    phonenumber: formPhoneNumber.value
                })
            });

            const data = await response.json();

            if (response.ok) {
                // Đăng ký thành công, chuyển hướng đến trang đăng nhập
                alert('Đăng ký thành công! Bạn sẽ được chuyển đến trang đăng nhập.');
                window.location.href = './Login.html';
            } else {
                // Đăng ký thất bại, hiển thị thông báo lỗi
                alert('Đăng ký thất bại: ' + data.message);
            }
        } catch (error) {
            console.error('Đã xảy ra lỗi:', error);
            alert('Đã xảy ra lỗi khi kết nối với server.');
        }
    }
});
