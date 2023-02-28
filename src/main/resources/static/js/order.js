var products = []; // danh sách sản phẩm

function addProduct() {
    var productName = document.getElementById("productName").value;
    var productPrice = document.getElementById("productPrice").value;
    var productQuantity = document.getElementById("productQuantity").value;

    // Kiểm tra thông tin sản phẩm hợp lệ
    if (productName === "" || productPrice === "" || productQuantity === "") {
        alert("Vui lòng nhập đầy đủ thông tin sản phẩm!");
        return;
    }

    // Tạo đối tượng sản phẩm mới và thêm vào danh sách
    var product = {
        name: productName,
        price: productPrice,
        quantity: productQuantity
    };
    products.push(product);

    // Hiển thị lại danh sách sản phẩm
    var tableBody = document.querySelector("table tbody");
    var newRow = tableBody.insertRow(-1);
    var nameCell = newRow.insertCell(0);
    var priceCell = newRow.insertCell(1);
    var quantityCell = newRow.insertCell(2);
    nameCell.innerHTML = productName;
    priceCell.innerHTML = productPrice;
    quantityCell.innerHTML = productQuantity;

    // Xóa thông tin sản phẩm trên form
    document.getElementById("productName").value = "";
    document.getElementById("productPrice").value = "";
    document.getElementById("productQuantity").value = "";
    console.log("ok");
}