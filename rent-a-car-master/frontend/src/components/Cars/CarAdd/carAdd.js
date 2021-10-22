import React from 'react';
import {useHistory} from 'react-router-dom';

const CarAdd = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        carmodel: 0,
        price: 0,
        year: 0,
        color: "blue",
        availableStatus: false
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const carmodel = formData.carmodel;
        const price = formData.price;
        const year = formData.year;
        const color = formData.color;
        const availableStatus = formData.availableStatus;

        props.onAddCar(carmodel, price, year, color, availableStatus);
        history.push("/cars");
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Car model</label>
                        <input type="text"
                               className="form-control"
                               id="carmodel"
                               name="carmodel"
                               required
                               placeholder="Enter car model"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="price">Price</label>
                        <input type="text"
                               className="form-control"
                               id="price"
                               name="price"
                               placeholder="Price"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Year</label>
                        <input type="text"
                               className="form-control"
                               id="year"
                               name="year"
                               placeholder="Year"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Color</label>
                        <input type="text"
                               className="form-control"
                               id="color"
                               name="color"
                               placeholder="Color"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Available Status</label>
                        <select name="availableStatus" className="form-control" onChange={handleChange} required>
                            <option value={false}>Choose option</option>
                            <option value={true}>Yes</option>
                            <option value={false}>No</option>
                        </select>
                    </div>
                    <div className="mt-3">
                        <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    )
}
export default CarAdd;
