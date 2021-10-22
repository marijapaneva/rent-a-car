import React from "react";
import CarTerm from '../CarTerm/carTerm';
import {Link} from 'react-router-dom';
import ReactPaginate from 'react-paginate';

class Cars extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            page: 0,
            size: 4

        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.cars.length / this.state.size);
        const cars = this.getCarsPage(offset, nextPageOffset);

        return (
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Model</th>
                                <th scope={"col"}>Price</th>
                                <th scope={"col"}>Year</th>
                                <th scope={"col"}>Color</th>
                                <th scope={"col"}>Available status</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            {cars}
                            </tbody>
                        </table>
                    </div>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/cars/add"}>Add new
                                    car</Link>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="col mb-5 mt-5 text-center" style={{background: "blue"}}>
                    <div className="row">
                        <div className="col-sm-12 col-md-12" style={{color: "white",fontSize: "3vh"}}>
                            {this.props.reservedMessage}
                        </div>
                    </div>
                </div>
                <ReactPaginate previousLabel={"back "}
                               nextLabel={" next"}
                               breakLabel={<a href="/#">...</a>}
                               breakClassName={"break-me"}
                               pageClassName={"ml-1"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active"}/>
            </div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getCarsPage = (offset, nextPageOffset) => {
        return this.props.cars.map((term, index) => {
            return (
                <CarTerm term={term} onDelete={this.props.onDelete} onEdit={this.props.onEdit} onReservation={this.props.onReservation}/>
            );
        }).filter((product, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }

}

export default Cars;