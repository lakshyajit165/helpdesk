import { ICommand } from './CommandInterface';

export interface ResponseFormat {
    result: Array<ICommand>;
    message: string;
    error: string;
}
