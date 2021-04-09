
function onlyDigits() {
    this.value = this.value.replace(/[^\d\,\-]/g, "");//разрешаем ввод только цифр 0-9, запятой и минуса

    if (this.value.lastIndexOf("-") > 0) {//если пользователь вводит тире (минус) не самым первым символом...
        this.value = this.value.substr(0, this.value.lastIndexOf("-"));//то удаляем этот минус
    }

    if (this.value[0] === "-") {//если первый символ это минус (число отрицательно)...
        if (new Set().add("6").add("7").add("8").add("9").has(this.value[1]))
            this.value = this.value.substr(0, 1);
        if (this.value[1] === "5" && this.value[2] !== "") {
            this.value = this.value.substr(0, 2);//то запрещаем вводить число больше 0
        }
        if (this.value.length > 2 && this.value[2] !== ",") this.value = this.value[0] + this.value[1] + "," + this.value[2];//если третий символ введён и он не запятая, то вставляем запятую между вторым и третим символом
        if (this.value.length > 8) this.value = this.value.substr(0, 8);//если количество символов равно 8 (5 знаков после запятой), не даём вводить больше
    } else {//если число положительно (первым введён не минус, а цифра)...
        if (new Set().add("4").add("5").add("6").add("7").add("8").add("9").has(this.value[0])) {
            this.value = this.value.substr(0, 0)//то эта цифра должна быть от 0 до 5
        }
        if (this.value[0] === "3" && this.value[1] !== "") {
            this.value = this.value.substr(0, 1);//то эта цифра должна быть от 0 до 5
        }

        if (this.value.length > 1 && this.value[1] !== ",") this.value = this.value[0] + "," + this.value[1];//если второй символ введён и он не запятая, то вставляем запятую между первым и вторым символом
        if (this.value.length > 7) this.value = this.value.substr(0, 7);//если количество символов равно 7 (5 знаков после запятой), не даём вводить больше
    }

    if (this.value.match(/,/g) !== null && this.value.match(/,/g).length > 1) {//не даём ввести больше одной запятой
        this.value = this.value.substr(0, this.value.lastIndexOf(","));
    }
    if (parseFloat(this.value))

        if (this.value.match(/-/g) && this.value.match(/-/g).length > 1) {//не даём ввести больше одного минуса
            this.value = this.value.substr(0, this.value.lastIndexOf("-"));
        }
}

function clear_graph() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx_points.clearRect(0, 0, canvas.width, canvas.height);
}

function draw_graph(radius) {
    let origin = 0;
    let border = canvas.width;
    let center = (origin + border) / 2;
    let arrow = border / 50;
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    radius = radius * (2 * border / 25);
    ctx.fillStyle = "black";
    ctx.strokeStyle = 'black';
    ctx.lineWidth = 4.0;
    ctx.beginPath();
    ctx.moveTo(origin, origin);
    ctx.lineTo(origin, border);
    ctx.lineTo(border, border);
    ctx.lineTo(border, origin);
    ctx.lineTo(origin, origin);
    ctx.lineWidth = 2.0;
    ctx.moveTo(center, border);
    ctx.lineTo(center, origin);
    ctx.lineTo(center + arrow, origin + arrow);
    ctx.moveTo(center, origin);
    ctx.lineTo(center - arrow, origin + arrow);// Ось Y

    ctx.moveTo(origin, center);
    ctx.lineTo(border, center);
    ctx.lineTo(border - arrow, center - arrow);
    ctx.moveTo(border, center);
    ctx.lineTo(border - arrow, center + arrow);// Ось X
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(center, center);
    ctx.lineTo(center, center - radius);
    ctx.quadraticCurveTo(center - radius, center - radius, center - radius, center);
    ctx.lineTo(center, center);
    ctx.fillStyle = '#1ADBD5';
    ctx.fill();
    ctx.stroke(); // полукруг

    ctx.beginPath();
    ctx.moveTo(center, center);
    ctx.lineTo(center, center + radius);
    ctx.lineTo(center - radius / 2, center + radius);
    ctx.lineTo(center - radius / 2, center);
    ctx.lineTo(center, center);
    ctx.fillStyle = '#1ADBD5';
    ctx.fill();
    ctx.stroke(); // ректангл

    ctx.beginPath();
    ctx.moveTo(center, center);
    ctx.lineTo(center, center + radius);
    ctx.lineTo(center + radius, center);
    ctx.lineTo(center, center);
    ctx.fillStyle = '#1ADBD5';
    ctx.fill();
    ctx.stroke(); // triangle
}

function add_point(x, y) {
    ctx_points.beginPath();
    ctx_points.arc(x, y, 3, 0, 2 * Math.PI, false);
    ctx_points.fillStyle = 'red';
    ctx_points.strokeStyle = 'red';
    ctx_points.fill();
    ctx_points.lineWidth = 1;
    ctx_points.stroke();
}

let canvas = $("#canvas")[0];

function cnvs_getCoordinates(e) {
    let x = e.pageX - e.target.offsetLeft;
    let y = e.pageY - e.target.offsetTop;
    xy_coordinates_show.innerHTML = "Coordinates: ("
        + ((2 * x - canvas.width) / (canvas.width) / 4 * 25).toFixed(3) + ","
        + ((canvas.height - 2 * y) / (canvas.height) / 4 * 25).toFixed(3) + ")";
}

function cnvs_clearCoordinates() {
    xy_coordinates_show.innerHTML = "";
}

let xy_coordinates_show = document.getElementById("xycoordinates");
let ctx = canvas.getContext('2d');
let ctx_points = canvas.getContext('2d');

// import {clear_graph,draw_graph,add_point,cnvs_getCoordinates,cnvs_clearCoordinates,
//     canvas,xy_coordinates_show,ctx,ctx_points} from './graph';
let errorFields = $("#errorFields");
let imageR = $("#image_R");
let imageX = $("#image_X");
let selectedR = $("#selectedR");
let selectedX = $("#selectedX");
let coordinateY = $("#coordinateY")[0];
let resetForm = $("#resetForm");

coordinateY.addEventListener("keyup", onlyDigits);
imageR.hide();
imageX.hide();
errorFields.hide();
$(".setR").click(function () {
    selectedR.html(this.value);
    imageR.show();
    draw_graph(parseFloat(selectedR.html()));
    canvas.addEventListener("click", GraphCheckPoints);
    canvas.addEventListener("mousemove", cnvs_getCoordinates);
    canvas.addEventListener("mouseout", cnvs_clearCoordinates);
    canvas.style.display = "";
    let coordinate = $("table tbody tr td");
    for (let i = 0; i < coordinate.length / 6; i++) {
        add_point(
            canvas.width / 2 + parseFloat(coordinate[i * 6 + 2].innerText) / 6.25 * (canvas.width / 2),
            canvas.height / 2 - parseFloat(coordinate[i * 6 + 3].innerText) / 6.25 * (canvas.height / 2)
        );
    } // drawing every points on the graph
});
$(".setX").click(function () {
    selectedX.html(this.value);
    imageX.show();
});
resetForm.click(function () {
    selectedR.html("");
    imageR.hide();
    selectedX.html("");
    imageX.hide();
    errorFields.hide();
    $("#message").innerHTML = "";
    canvas.removeEventListener("click", GraphCheckPoints);
    canvas.removeEventListener("mousemove", cnvs_getCoordinates);
    canvas.removeEventListener("mouseout", cnvs_clearCoordinates);
    canvas.style.display = "none";
});

function FormCheckPoints() {
    function validate(R, X, Y) {
        return (
            (!isNaN(parseFloat(R)) && parseFloat(R) >= 1 && parseFloat(R) <= 5) &&
            (!isNaN(parseInt(X)) && parseFloat(X) >= -3 && parseFloat(X) <= 5) &&
            (!isNaN(parseFloat(Y)) && parseFloat(Y) >= -5 && parseFloat(Y) <= 5)
        )
    }

    errorFields.hide();
    let R = selectedR.html();
    let X = selectedX.html();
    let Y = coordinateY.value.replace(",", ".");
    if (validate(R, X, Y)) {
        let formData = new FormData();
        formData.set('R', R);
        formData.set('X', X);
        formData.set('Y', Y);
        fetch("index", {
            method: 'POST',
            body: formData
        })
            .then(response => {
                return response.text();
            })
            .then(result => {
                if (result !== "") {
                    $(".result")[0].innerHTML = result;
                    add_point(canvas.width / 2 + parseFloat(X) / 6.25 * (canvas.width / 2),
                        canvas.height / 2 - parseFloat(Y) / 6.25 * (canvas.height / 2));
                }
            });
    } else {
        errorFields.show();
    }
}

function GraphCheckPoints(e) {
    let X = e.pageX - e.target.offsetLeft;
    let Y = e.pageY - e.target.offsetTop;
    let formData = new FormData();
    formData.set('R', selectedR.html());
    formData.set('X', ((2 * X - canvas.width) / (canvas.width) * 25 / 4).toFixed(6));
    formData.set('Y', ((canvas.height - 2 * Y) / (canvas.height) * 25 / 4).toFixed(6));
    fetch("index", {
        method: 'POST',
        body: formData
    })
        .then(response => {
            return response.text();
        })
        .then(result => {
            if (result !== "") {
                $(".result")[0].innerHTML = result;
                add_point(X, Y);
            }
        });
}