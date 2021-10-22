import axios from '../custom-axios/axios2';

const ReserveRepository2 = {
    reserveCar: (id) => {
        return axios.get(`/cars/${id}`)
    }
}
export default ReserveRepository2;