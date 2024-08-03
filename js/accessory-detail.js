const formId = document.getElementById("id");
const formLicensePlate = document.getElementById("license-plate");
const formRepairDate = document.getElementById("repair-date");
const formName = document.getElementById("name");
const formPrice = document.getElementById("price");
const formStatusDamaged = document.getElementById("status-damaged");
const formRepairStatus = document.getElementById("repair-status");
const form = document.getElementById("accessory-form");
const tbody = document.getElementById("accessories");

const BASE_URL = "http://localhost:8080";

form.addEventListener("submit", async function (event) {
	event.preventDefault();
	await createOrUpdate();
	this.reset();
	findAll();
});

document.getElementById("size").onchange = findAll;
document.getElementById("page").onchange = findAll

// load dữ liệu hiển thị ra màn hình
findAll();

async function findAll() {
	loading.style.display = "flex";
    const url = new URL(`${BASE_URL}/api/v1/accessories`);
    url.search = new URLSearchParams({
        page: document.getElementById("page").value,
        size: document.getElementById("size").value
    }).toString();
    const response = await fetch(url, {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
    });
	const body = await response.json();
	showAccessories(body.content);
	updatePagination(body.number + 1);
	loading.style.display = "none";
}

function showAccessories(accessories) {
	tbody.innerHTML = "";
	for (const accessory of accessories) {
		const row = tbody.insertRow();
		row.insertCell().textContent = accessory.id;
		row.insertCell().textContent = accessory.licensePlate;
		row.insertCell().textContent = accessory.repairDate;
		row.insertCell().textContent = accessory.name;
		row.insertCell().textContent = accessory.price;
		row.insertCell().textContent = accessory.statusDamaged;
		row.insertCell().textContent = accessory.repairStatus;

		const editButton = document.createElement("button");
		editButton.textContent = "🖊";
		editButton.onclick = function () {
			formId.value = accessory.id;
			formLicensePlate.value = accessory.licensePlate;
			formRepairDate.value = accessory.repairDate;
			formName.value = accessory.name;
			formPrice.value = accessory.price;
			formStatusDamaged.value = accessory.statusDamaged;
			formRepairStatus.value = accessory.repairStatus;
		};
		const deleteButton = document.createElement("button");
		deleteButton.textContent = "❌";
		deleteButton.onclick = async function () {
			const confirmed = confirm("Do you want to delete this accessory?");
			if (confirmed) {
				await deleteById(accessory.id);
				tbody.removeChild(row);
			}
		};
		row.insertCell().append(editButton, deleteButton);
	}
}

async function createOrUpdate() {
	const id = formId.value;
	const method = id ? 'PUT' : 'POST';
	const url = id
		? `${BASE_URL}/api/v1/accessories/${id}`
		: `${BASE_URL}/api/v1/accessories`;
	const response = await fetch(url, {
		method: method,
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify({
			name: formName.value,
			price: formPrice.value,
			statusDamaged: formStatusDamaged.value,
			repairStatus: formRepairStatus.value,
			licensePlate: formLicensePlate.value,
			repairDate: formRepairDate.value
		})
	});
	const accessory = await response.json();
	alert("Tạo accessory thành công: " + accessory.name);
}

async function deleteById(id) {
	const response = await fetch(`${BASE_URL}/api/v1/accessories/${id}`, {
		method: "DELETE",
		headers: {
			"Content-Type": "application/json"
		}
	});
}

function updatePagination(page){
	const pageInput = document.getElementById("page");
	pageInput.value = page;

	const goToPage = page =>{
		pageInput.value = page;
		findAll();
	}

	const prevPageButton = document.getElementById("prev-page");
	prevPageButton.onclick = function (){
		goToPage(page -1);
	}

	const nextPageButton = document.getElementById("next-page");
	nextPageButton.onclick = function(){
		goToPage(page +1);
	}
}