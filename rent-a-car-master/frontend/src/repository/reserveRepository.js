import axios from '../custom-axios/axios';

const ReserveRepository = {
    getCars: () => {
        return axios.get(`/cars`)
    },
    deleteCar: (id) => {
        return axios.delete(`/cars/delete/${id}`);
    },
    addCar: (carmodel, price, year, color, availableStatus) => {
        return axios.post("/cars/add", {
            "carmodel": carmodel,
            "price": price,
            "year": year,
            "color": color,
            "availableStatus": availableStatus
        });
    },
    editCar: (id,carmodel, price, year, color, availableStatus) => {
        return axios.put(`/cars/edit/${id}`, {
            "carmodel": carmodel,
            "price": price,
            "year": year,
            "color": color,
            "availableStatus": availableStatus
        })
    },
    get: (id) => {
        return axios.get(`/cars/${id}`)
    },
    reserveCar: (id) => {
        return axios.get(`/cars/${id}`)
    }
}
export default ReserveRepository;