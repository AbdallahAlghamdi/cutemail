<div>
    <section>
        <button>
            <img
                src="icons/piiixl/ui/trashcan-open.png"
                alt="trash can"
                title="delete selected email"
            />
        </button>

        <button>
            <img
                src="icons/piiixl/ui/floppy-disk.png"
                title="Save selected mail"
                alt="save"
            />
        </button>
        <button>
            <img
                src="icons/piiixl/ui/compose.png"
                title="compose new mail"
                alt="new mail"
            />
        </button>
    </section>
    <table>
        <thead>
            <tr>
                <th></th>
                <th>Sender</th>
                <th>Subject</th>
                <th>Date</th>
                <th>
                    <img
                        src="icons/piiixl/ui/attachment.png"
                        alt="attachment"
                        title="shows the amount of attachments in the mail"
                    />
                </th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <img
                        src="/icons/piiixl/ui/mail-closed.png"
                        alt="read mail"
                    />
                </td>

                <td class="name">!:Gargemi</td>
                <td class="subject"
                    >Your account has been flagged for deletion</td
                >
                <td class="date">01/12/2005</td>
                <td>1</td>
            </tr>
            <tr>
                <td>
                    <img src="/icons/piiixl/ui/mail-open.png" alt="read mail" />
                </td>
                <td class="name">♠:Ahmed</td>
                <td class="subject"
                    >Have you seen the <b>news?</b>? What should we tell others?</td
                >
                <td class="date">01/12/2005</td>
                <td></td>
            </tr>
        </tbody>
    </table>
</div>

<!-- ♥ ♦ ♣ ♠ -->

<style>
    img {
        width: calc(16px * 2);
        height: calc(16px * 2);
    }
    div {
        overflow: scroll;
        height: 100%;
        width: 100%;
    }
    .name {
        padding: 0px 3px;
    }

    .subject {
        width: 100%;
        padding: 6px;
        text-wrap: pretty;
    }
    table {
        padding: 10px 10px;
        /* border-collapse: collapse; */
        width: 100%;
    }
    th {
        border: 2px #303843 solid;
        border-right: none;
        height: 40px;
    }
    th:last-child {
        border: 2px #303843 solid;
        min-width: 25px;
    }
    thead tr {
        position: sticky;
        top: 0px;
        background-color: #7a5859;
        color: #f2b888;
        font-weight: 900;
        border-collapse: separate;
    }

    td:last-child {
        text-align: center;
    }

    tbody tr:nth-child(even) {
        background-color: #7f705c;
        color: #fee1b8;
    }
    tbody tr {
        /* position: relative; */
        /* transform: translate(0); */
        transition: background-color 0.25s;
    }
    /* tbody tr:hover::after {
        left: -10px;
        bottom: -30px;
        position: absolute;
        content: url("icons/aspecs/Hand3.png");
        z-index: 10;
        transform: rotateY(180deg);
    } */
    th:last-child {
        display: flex;
        align-items: center;
    }
    td {
        cursor: url("icons/mayke_arth/cursor-06.png"), pointer;
        /* height: 50px; */
        padding: 6px;
    }
</style>
