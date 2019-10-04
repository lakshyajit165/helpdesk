export interface ReportResponse {
    result: [
        {
            type: string;
            intent: [
                {
                    name: string;
                    queries: [
                        {
                            queryName: string;
                            date: Date;
                        }
                    ];
                }
            ];
        }
    ];

}
