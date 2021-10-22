import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Cars from "../Cars/CarList/cars"
import CarAdd from "../Cars/CarAdd/carAdd";
import ReserveRepository from "../../repository/reserveRepository";
import ReserveRepository2 from "../../repository/reserveRepository2";
import CarEdit from "../Cars/CarEdit/carEdit";
import Header from "../Header/header"

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cars: [],
            selectedCar: {},
            reservedMessage: ""
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/cars"} exact
                               render={() => <Cars cars={this.state.cars}
                                                   onDelete={this.deleteCar}
                                                   onReservation={this.reserveCar}
                                                   onEdit={this.getCar}
                                                   reservedMessage={this.state.reservedMessage}/>}/>
                        <Route path={"/cars/add"} exact render={() => <CarAdd onAddCar={this.addCar}/>}/>
                        <Route path={"/cars/edit/:id"} exact render={() => <CarEdit onEditCar={this.editCar} car={this.state.selectedCar}/>}/>
                        <Redirect to={"/cars"}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadCars();
    }

    loadCars = () => {
        ReserveRepository.getCars()
            .then((data) => {
                this.setState({
                    cars: data.data
                })
            });
    }
    deleteCar = (id) => {
        ReserveRepository.deleteCar(id)
            .then(() => {
                this.loadCars();
            });
    }
    addCar = (carmodel, price, year, color, availableStatus) => {
        ReserveRepository.addCar(carmodel, price, year, color, availableStatus)
            .then(() => {
                this.loadCars();
            });
    }
    editCar = (id, carmodel, price, year, color, availableStatus) => {
        ReserveRepository.editCar(id, carmodel, price, year, color, availableStatus)
            .then(() => {
                this.loadCars();
            });
    }
    getCar = (id) => {
        ReserveRepository.get(id)
            .then((data) => {
                this.setState({
                    selectedCar: data.data
                })
            })
    }
    reserveCar = (id) => {
        ReserveRepository2.reserveCar(id)
            .then((data) => {
                console.log(data.data)
                this.setState({
                    reservedMessage: "Successfully reserved car."
                })
                this.loadCars()
            })
    }
}

export default App;