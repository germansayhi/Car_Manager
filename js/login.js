document.addEventListener("DOMContentLoaded", function() {
    const formUsernameOrEmail = document.getElementById("username");
    const formPassword = document.getElementById("password");
    const form = document.querySelector(".form-signin");

    form.addEventListener("submit", function(event) {
        event.preventDefault(); // Ngăn chặn hành động mặc định của form
        login(); // Gọi hàm đăng nhập
    });

    const BASE_URL = "http://localhost:8080";

    async function login() {
        try {
            const username = formUsernameOrEmail.value;
            const password = formPassword.value;
            const auth = btoa(`${username}:${password}`);
            const response = await fetch(`${BASE_URL}/api/v1/login`, {
                method: "GET", 
                headers: {
                    "Authorization": "Basic " + auth,
                    "Content-Type": "application/json"
                },
            });

            if (response.ok) {
                // Đăng nhập thành công, lưu mã thông báo và chuyển hướng đến trang quản lý xe
                // {
                //     "id": 1,
                //     "fullname": "Bùi Quang Đức",
                //     "username": "duc.qb",
                //     "email": "bqd122002@gmail.com",
                //     "phonenumber": "0372333333",
                //     "role": null
                // }
                const userData = await response.json();
                const token = userData.token; // Giả sử token được trả về từ serverlog
                console.log(`${username}:${password}`);
                
                const { fullname, avatar } = userData; // Lấy fullname và avatar từ dữ liệu trả về
                
                localStorage.setItem('userData', JSON.stringify({ fullname, avatar })); // Lưu thông tin vào localStorage
                localStorage.setItem('username', JSON.stringify(username)); // Lưu mã thông báo vào localStorage
                localStorage.setItem('password', JSON.stringify(password)); // Lưu mã thông báo vào localStorage
                alert('Đăng nhập thành công, chào mừng ' + userData.fullname + '!');
                window.location.href = '/html/add-new-car.html';
            } else {
                // Đăng nhập thất bại, hiển thị thông báo lỗi
                alert('Đăng nhập thất bại: Vui lòng kiểm tra lại thông tin đăng nhập.');
            }
        } catch (error) {
            console.error('Đã xảy ra lỗi:', error);
            alert('Đã xảy ra lỗi khi kết nối với server.');
        }
    }
});




