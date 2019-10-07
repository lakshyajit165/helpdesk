export interface ICommand {
    id: string;
    name: string;
    tags: string[];
    desc: string;
    last_updated_on: string;
    created_on: string;
    created_by: string;
    usage: string;
    status: string;
<<<<<<< HEAD
    parametersList: [{
=======


    parameters: [{
>>>>>>> c1e4967e709eb6f55bf551ed0a41cc0219e96a69
        parameterName: string;
        required: string;
        default_value: string;
        description: string;
    }];
}
