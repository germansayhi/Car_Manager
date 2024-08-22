document.addEventListener("DOMContentLoaded", function() {
    const userInfoContainer = document.getElementById("user-info");
    const userAvatar = document.getElementById("avatar");
    const userName = document.getElementById("username");
    const logoutButton = document.getElementById("logout-btn");
    const authButtons = document.getElementById("auth-buttons");
    
    function updateUserInfo() {
        const userData = localStorage.getItem('userData');
        
        if (userData) {
            const { fullname, avatar } = JSON.parse(userData);
            
            userName.textContent = fullname;
            userAvatar.src = avatar || '../img/avatar-default.jpg'; // Sử dụng ảnh mặc định nếu không có
            userInfoContainer.style.display = 'flex';
            authButtons.style.display = 'none'; // Ẩn nút Đăng nhập/Đăng ký khi đã đăng nhập
        } else {
            userInfoContainer.style.display = 'none';
            authButtons.style.display = 'flex'; // Hiển thị nút Đăng nhập/Đăng ký khi chưa đăng nhập
        }
    }

    function logout() {
        const username = JSON.parse(localStorage.getItem("username"));
	    const password = JSON.parse(localStorage.getItem("password"));
        localStorage.removeItem('userData');
        localStorage.removeItem('username');
        localStorage.removeItem('password');
        window.location.href = './index.html';
        this.reset();
    }

    logoutButton.addEventListener("click", logout);

    updateUserInfo();
});


