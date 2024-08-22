const formLicensePlate = document.getElementById
("license-plate");
const formRepairDate = document.getElementById
("repair-date");
const formCustomerName = document.getElementById
("customer-name");
const formCatalog = document.getElementById
("catalog");
const formCarMaker = document.getElementById
("car-maker");
const form = document.getElementById
("car-create-form");

form.addEventListener("submit", function(event){
    event.preventDefault();
    create();
    this.reset();
});

const BASE_URL ="http://localhost:8080"

 async function create(){
	const username = JSON.parse(localStorage.getItem("username"));
	const password = JSON.parse(localStorage.getItem("password"));

    const respone = await fetch(`${BASE_URL}/api/v1/cars`,{
        method: "POST",
        headers:{
            "Content-Type": "application/json",
            "Authorization": "Basic " + btoa(username+":"+password),
        },
        body:JSON.stringify({
            licensePlate: formLicensePlate.value,
            repairDate : formRepairDate.value,
            customerName : formCustomerName.value,
            catalog : formCatalog.value,
            carMaker : formCarMaker.value,
        })
    });
    const  car = await respone.json();
    alert("Tạo thành công car:"+ car.licensePlate);
}
