const configDatatable = {
    language: {
        url: "../vendors/datatables/vi.json",
    },
    columnDefs: [
        {
            targets: 0,
            searchable: false,
            orderable: false,
        },
    ],
};

function showToast(text = '', title = 'Thông báo', type = 'success') {
    Swal.fire({
        title: title,
        text: text,
        icon: type,
        toast: true,
        position: "top-right",
        showConfirmButton: false,
        timer: 1500,
        timerProgressBar: true,
    });
}

function showAlert(text = "", type = "error", title = "Thông báo") {
    Swal.fire({
        icon: type,
        title: title,
        text: text,
    });
}

function showConfirm(text = "", confirmedFunction) {
    Swal.fire({
        title: "Xác nhận",
        text: text,
        icon: "warning",
        showCancelButton: true,
        allowEnterKey: true,
    }).then((result) => {
        if (result.isConfirmed) {
            if (confirmedFunction) {
                confirmedFunction();
            }
        }
    });
}

function showLoading() {
    $("#fetch-loading").removeClass("d-none");
}
function hideLoading() {
    $("#fetch-loading").addClass("d-none");
}

async function axiosPost(url, data, successFunction, errorFunction) {
    showLoading();
    try {
        const request = await axios.post(url, data);

        await request.response;

        if (successFunction) {
            successFunction(request);
        }
    } catch (error) {
        console.log(error);

        if (errorFunction) {
            errorFunction(error.response);
        } else {
            showAlert(error.response.data.message);
        }
    }
    hideLoading();
}
async function axiosGet(url, successFunction, errorFunction) {
    showLoading();
    try {
        const request = await axios.get(url);

        await request.response;

        if (successFunction) {
            successFunction(request);
        }
    } catch (error) {
        console.log(error);

        if (errorFunction) {
            errorFunction(error.response);
        } else {
            showAlert(error.response.data.message);
        }
    }
    hideLoading();
}

async function axiosDelete(url, successFunction, errorFunction) {
    showLoading();
    try {
        const request = await axios.delete(url);

        await request.response;

        if (successFunction) {
            successFunction(request);
        }
    } catch (error) {
        console.log(error);

        if (errorFunction) {
            errorFunction(error.response);
        } else {
            showAlert(error.response.data.message);
        }
    }
    hideLoading();
}
async function axiosPut(url, data, successFunction, errorFunction) {
    showLoading();
    try {
        const request = await axios.put(url, data);

        await request.response;

        if (successFunction) {
            successFunction(request);
        }
    } catch (error) {
        console.log(error);

        if (errorFunction) {
            errorFunction(error.response);
        } else {
            showAlert(error.response.data.message);
        }
    }
    hideLoading();
}
$(document).on(
    "click",
    '.input-group-text[data-password="false"]',
    function () {
        const input = $(this).parents(".input-group").first();

        input.find('input[type="password"]').prop("type", "text");

        $(this)[0].dataset.password = true;
        $(this).addClass("show-password");
    }
);

$(document).on("click", '.input-group-text[data-password="true"]', function () {
    const input = $(this).parents(".input-group").first();

    input.find('input[type="text"]').prop("type", "password");

    $(this)[0].dataset.password = false;
    $(this).hideClass("show-password");
});
