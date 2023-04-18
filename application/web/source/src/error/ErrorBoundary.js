import {Component} from "react";
import {Navigate} from "react-router-dom";

const HighOrderBoundary = (ErrorComponent) =>
    class ErrorBoundary extends Component {
        state = {hasError: false};

        componentDidMount() {
            window.self.addEventListener("error", () =>
                this.setState({hasError: true})
            );
        }

        componentDidCatch() {
            this.setState({hasError: true});
        }

        render() {
            if (this.state.hasError) {
                this.setState({hasError: false});
                return (
                    <Navigate to="error" replace/>
                );
            }
            return <ErrorComponent/>;
        }
    };

export default HighOrderBoundary;