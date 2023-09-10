function deleteUser(path) {
    if (confirm("Bạn chắc chắn xóa user không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống có lỗi! Vui lòng quay lại sau!");
        });
    }
}


function deletePost(path) {
    if (confirm("Bạn chắc chắn xóa Post không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống có lỗi! Vui lòng quay lại sau!");
        });
    }
}

function updateStatusPostJS(path) {
    // Thay đổi URL này thành URL của máy chủ của bạn
    // Sử dụng phương thức PUT để cập nhật dữ liệu
    fetch(path, {
        method: 'PUT', // Hoặc 'PATCH' nếu máy chủ hỗ trợ
        headers: {
            'Content-Type': 'application/json' // Định dạng dữ liệu gửi lên
        },
        body: JSON.stringify(dataToUpdate) // Dữ liệu cần cập nhật (chuyển thành chuỗi JSON)
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Có lỗi khi cập nhật dữ liệu'); // Xử lý lỗi nếu có
                }
                return response.json(); // Trả về phản hồi JSON từ máy chủ nếu thành công
            })
            .then(updatedData => {
                console.log('Dữ liệu đã được cập nhật thành công:', updatedData);
                alert("Duyệt thành công !!!");

                // Thực hiện các thao tác khác sau khi cập nhật thành công
            })
            .catch(error => {
                console.error('Lỗi khi cập nhật dữ liệu:', error);
                // Xử lý lỗi nếu cần thiết
            });
}

// Sử dụng hàm để cập nhật dữ liệu
const dataToUpdate = {
    // Dữ liệu cần cập nhật
    // Đảm bảo bạn có dữ liệu thích hợp và cập nhật URL API phù hợp
    "status": 1
};

