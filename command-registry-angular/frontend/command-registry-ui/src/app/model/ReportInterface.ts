export interface ReportInterface {
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
