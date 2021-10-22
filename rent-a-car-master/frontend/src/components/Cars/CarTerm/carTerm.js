import React from "react";
import {Link} from 'react-router-dom';

const carTerm = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.term.carmodel}</td>
            <td scope={"col"}>{props.term.price}</td>
            <td scope={"col"}>{props.term.year}</td>
            <td scope={"col"}>{props.term.color}</td>
            {props.term.availableStatus && (
                <td scope={"col"}>Yes</td>
            )}
            {!props.term.availableStatus && (
                <td scope={"col"}>No</td>
            )}
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id.id)}
                      to={`/cars/edit/${props.term.id.id}`}>
                    Edit
                </Link>
                <a title={"Reserve"} className={"btn btn-success"}
                   onClick={() => props.onReservation(props.term.id.id)}>
                    Reserve
                </a>
            </td>
        </tr>
    )
}
export default carTerm;
